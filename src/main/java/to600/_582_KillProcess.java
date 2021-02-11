package to600;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class _582_KillProcess {

    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < ppid.size(); i++) {
            if (ppid.get(i) > 0) {
                List<Integer> list = map.getOrDefault(ppid.get(i), new ArrayList<>());
                list.add(pid.get(i));
                map.put(ppid.get(i), list);
            }
        }
        List<Integer> res = new ArrayList<>();
        res.add(kill);
        getAllProcess(map, res, kill);
        return res;
    }

    private void getAllProcess(HashMap<Integer, List<Integer>> map, List<Integer> res, int kill) {
        if (map.containsKey(kill)) {
            for (int id : map.get(kill)) {
                res.add(id);
                getAllProcess(map, res, id);
            }
        }
    }


}
