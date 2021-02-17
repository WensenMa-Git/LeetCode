#### Design eCommerce Website (Part I)

First of all, building an eCommerce website requires things like database design, system availability, concurrency consideration and so on so forth. All of them are extremely important in today’s distributed systems. In addition, everyone has used some eCommerce website like Amazon. If you are generally curious about surroundings, you should have already thought about this topic.
eCommerce model

A common strategy of system design interview is starting with simple and basic things instead of jumping into details directly. So how would you design the basic data structure of an eCommerce website? And what about the database schema?

I’ll skip the data structure for user models as it should be quite similar to other applications. Let’s focus on the product. In the simplest scenario, we need three major objects: Product, User and Order.

Product defines the basic model for a product in the shopping cart. Some important fields include price, the amount left, name, description, and the category. Category can be tricky here. Of course you can make it a string field in the SQL database, but a better approach is to have a Category table that contains category ID, name and maybe other information. So the each product can keep a category ID.

Order stores information about all the orders made by users. So each row contains the product ID, user ID, amount, timestamp, status and so on. So when a user proceeds to checkout, we aggregate all the entries associated with this user to display in the shopping cart (of course we should filter out items that were bought in the past).

NoSQL in eCommerce

In the above analysis, we are using a relational database like MySQL. In reality, NoSQL database can be a better choice for eCommerce website sometimes.

In case many people don’t know about NoSQL, in layman’s term, NoSQL database tries to store a bunch of things in a single row instead of multiple tables. For instance, instead of having a separate Order table, we can store all the items a user has bought in the same row of User table. As a result, when fetching a user, not only will we get all the personal information, but also his purchase history.

Why can NoSQL be (slightly) better in this case? Let’s use Product model as an example. Suppose we are selling books. A product has category book and tons of attributes like author, publish date, version, the number of pages etc. and this SQL table may have 20 columns. That’s fine.

And now, we also want to sell laptops. So a product should also store attributes of a laptop including brand name, size, color etc.. As you can imagine, with more categories introduced, the Product table can have tons of columns. If each category has 10 attributes in average, it’s gonna be 100 columns with only 10 categories supported!

However, for NoSQL database like MongoDB, a great advantage is that it supports huge number “columns” like this. Each row can have a large number columns but not all of them are set. It’s like storing JSON object as a row (in fact, MongoDB is using something very similar called BSON). As a result, we can just store all those attributes (columns) of a product in a single row, which is exactly what NoSQL database good at.

Concurrency

Let’s move on to talk about scaling issues. When scaling an eCommerce website to multiple machines, there are tons of problems popping up. The most important thing is that eCommerce website has almost zero tolerance to most of this issues.

Take concurrency as an example. let’s say there’s only one book left in the store and two people buy it simultaneously. Without any concurrency mechanism, it’s absolutely possible that both have bought it successfully. How do you achieve concurrency in eCommerce websites?

Let’s analyze this step by step. From what we learned from OS classes, we know that lock is the most common technique to protect common resources. Suppose both user A and B want to buy the same book. What we can do is when A fetches the data about this book, place a lock on this row so that no one else can access it. Once A finishes the purchase (decrease the amount left), we release the lock so that B can access the data. The same approach should apply for all the resources and this can solve the problem totally.

The above solution is called pessimistic concurrency control. Although it prevents all the conflicts caused by concurrency, the downside is that it’s costly. Obviously, for every data access we need to create and release a lock, which may be unnecessary most of the time.

Can we solve the problem without a lock?

Summary

We’ll talk about a better solution for concurrency issue without using a lock in the next post. There are so many topics I’d like to cover about eCommerce websites.

In fact, many techniques are common across all distributed systems, what’s important is to compare the pros and cons of each approach and select the one that works best for the particular application.

In the next post, we’ll continue discussing concurrency and will also talk about system availability and consistency.


#### Design eCommerce Website (Part II)

This is the second post of Design eCommerce Website series posts. If you haven’t read the first post, it’s better to check it first as we’ll continue our discussion here.

To briefly remind you what we have discussed in the previous post, we started with the data model design for an eCommerce website. Although relational database is the most common approach, we notice that NoSQL database like MongoDB provides a lot of advantages and flexibilities when building an eCommerce website. To scale the system, concurrency is one of the key factors to consider.

 In the post, I’ll mostly focus on scalability of eCommerce websites. Building a single machine system can be simple, but when we decide to scale the website to support millions or even billions of requests with multiple servers, tons of scalability issues need to be considered.

Concurrency (continued)

One common scenario is that there’s only one book left in the store and two people buy it simultaneously. Without any concurrency mechanism, it’s absolutely possible that both have bought it successfully.

In our previous post, we know that one approach is to place a lock on the row whenever someone accesses the resource (book) so that at most one person can read/write the data at a time. The solution is called pessimistic concurrency control. Although the approach can prevent two people accessing the same data simultaneously, placing locks is quite costly. How would you solve this problem more efficiently?

Optimistic concurrency control is another way to support concurrency. The idea is very simple – instead of using locks, each process/thread can access data freely. However, before committing changes, each transaction should check if the data has the same state as it did when you last read it. In other words, you check the data in the beginning of the transaction and check again before committing to see if they are still the same.

If the data hasn’t been modified, you can safely commit it. Otherwise, roll back and try again until there’s no conflict. It’s important to compare the two approaches here. For OCC (Optimistic concurrency control), apparently it’s more efficient to read/write data unless there are conflicts. With that in mind, for systems that are unlikely to have conflicts, OCC is a better option. However, when resources are frequently accessed by multiple clients, restarting transaction becomes costly in OCC and it’s better to place locks in each transaction (PCC).

In applications like Amazon, there are so many products that it’s not that frequent to have multiple people accessing the same product simultaneously. As a result, OCC is a better choice.

Availability in eCommerce

It’s a big loss if Amazon website is down for 1 minute. To achieve high availability in distributed systems, the best way is to have hundreds or thousands of replicas so that you can tolerate many failures. However, it’s worth to note here that availability and consistency go hand in hand.

If you have many replicas, it’s definitely harder to guarantee that each replica has the same data. On the flip side, if you want to achieve high consistency, you’d better have fewer replicas, thus the system is prone to failure.

The idea here is not trying to achieve both. Instead, based on the nature of the product, you should be able to make the trade-off. For an eCommerce website, latency and down time usually means losing revenue, which can be a big number sometimes. As a result, we might care more about availability than consistency. The latter can be improved through other approaches.
Consistency in eCommerce

Given that we have hundreds or thousands of replicas, how would you guarantee that each replica keeps the same data? To explain the problem in detail, suppose data D is replicated in multiple servers. When a process is trying to update D to D1, it starts from one server and follows a particular order to propagate the changes. At the same time, another process is trying to update D to D2 and it may start from another server. As a result, some servers having data D1 and some D2.

Strong consistency

One approach is to force all updates to happen in the same order atomically. More specifically, when someone is updating the resource, it’s locked across all servers until all of them share the same value (after the update). As a result, if an application is built upon a system with strong consistency, it’s exactly the same as working on a single machine. Apparently, this is the most costly approach as not only is placing locks expensive, but it also blocks the system for every update.

Weak consistency

Another extreme case is that we can provide minimum curation. Every replica will see every update, however, they may be in different orders. As a result, this approach makes the update operation extremely light-weighted, but the downside is providing a minimum guarantee of consistency.

Note: we are not explaining the accurate definition of consistency model. Instead, we’d like to illustrate ideas with examples, which are more helpful for preparing system design interviews.

Eventual consistency

As you can imagine, a more practical approach lies somewhere in between. In a nutshell, the system only guarantees that every replica will have the same value eventually. At a certain period of time, data might be inconsistent. But in the long term, the system will resolve the conflict.

Let’s take Amazon’s Dynamo as an example. Basically, it’s possible that each replica holds different versions of the data at a particular time. So when the client read the data, it may get multiple versions. At this point, the client (instead of the database) is responsible to resolve all the conflicts and update them back to the server.

You might wonder how does the client resolve those conflicts. It’s mostly a product decision. Take the shopping cart as an example, it’s very important to not lose any additions since losing additions means losing revenue. So when facing different values, the client can just choose the one with most items.

 

Summary

As you can see, a lot of techniques here are common among distributed systems. What’s important is to understand the trade-off between each other and select the approach that best fit the product.

By the way, if you want to have more guidance from experienced interviewers, you can check Gainlo that allows you to have mock interview with engineers from Google, Facebook etc..

Reference: http://blog.gainlo.co/index.php/2016/08/22/design-ecommerce-website-part/
