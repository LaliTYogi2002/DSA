public class MinimumWIndowSubstring{
   public String minWindow(String s, String t) {
        if(s.length() < t.length()){
            return "";
        }

        HashMap<Character,Integer> map = new HashMap<>();

        for(int i = 0 ;i<t.length();i++){
            char c = t.charAt(i);
            map.put(c, map.getOrDefault(c,0)+1);
        }
        int i=0,j=0,n=s.length(),m=t.length();
        int count = map.size();
        String ans = "";
        int minLength=Integer.MAX_VALUE;

        while(j<n){
            char cur = s.charAt(j);
            if(map.containsKey(cur)){
                map.put(cur,map.getOrDefault(cur,0)-1);
                if(map.get(cur)== 0 ){
                    count--;
                }
            }

            if(count == 0 ){
                while(count==0){
                    if(j-i+1 < minLength){
                        ans = s.substring(i,j+1);
                        minLength = j-i+1;
                    }
                    char iCurr = s.charAt(i);
                    if(map.containsKey(iCurr)){
                        map.put(iCurr,map.getOrDefault(iCurr,0)+1);
                        if(map.get(iCurr) > 0){
                            count++;
                        }
                    }

                    i++;
                } 
            }

            j++;

        }
        return ans;
    }
}