import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindAllAnagramsInAString {
       public List<Integer> findAnagrams(String s, String p) {
        int n = s.length();
        int k = p.length();

        ArrayList<Integer> res = new ArrayList<Integer>();

        HashMap<Character, Integer> map = new HashMap<>();
        int count = 0;
        for(int i = 0 ;i<k;i++){
            char c = p.charAt(i);
            if(map.containsKey(c)){
                map.put(c, map.getOrDefault(c, 0)+1);
            }else{
                map.put(c, map.getOrDefault(c, 0)+1);
                count++;
            }
        }
        int i = 0 ;
        int j = 0 ;

        
        while(j<n){
            char c = s.charAt(j);
             if(map.containsKey(c)){
                    map.put(c,map.getOrDefault(c, 0)-1 );
                    if(map.getOrDefault(c, -1) == 0){
                        count--;
                    }
                }
            if(j-i+1 == k){
                char rem = s.charAt(i);

                if(count == 0){
                    res.add(i);
                }

                if(map.containsKey(rem)){
                    if (map.get(rem) == 0) {
                        count++;
                        }
                    
                    map.put(rem,map.getOrDefault(rem, 0)+1 );
                }

                j++;
                i++;
            }else{
                j++;
            }
        }

        return res ;
    }
}
