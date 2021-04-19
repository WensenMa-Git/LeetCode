import Link from 'umi/link'
import styles from './index.css';

export default function () {
  const usersList = [
    { id: 1, name: 'tim' },
    { id: 2, name: 'jerry' }
  ]
  return (
    <div className={styles.normal}>
      <h1>用户也users下的 index页面</h1>
      <ul>
        {usersList.map(val => (
          <li key={val.id}>
            <Link to={`/users/${val.name}`}>
              {val.name}
            </Link>
          </li>
        ))}
      </ul>
    </div>
  );
}
