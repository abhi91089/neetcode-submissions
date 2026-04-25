class Solution {
    public int lengthOfLongestSubstring(String s) {

        Map<Character,Integer> sub = new HashMap<>();

        int left = 0;
        int maxlen =0;
        
        
        for( int right=0;right<s.length();right++)
        {
            sub.putIfAbsent(s.charAt(right),0);
            sub.put(s.charAt(right),sub.get(s.charAt(right))+1);
            while(sub.get(s.charAt(right)) > 1)
            {
              
              sub.put(s.charAt(left),sub.get(s.charAt(left))-1);
              left++;
            }
            
            maxlen = Math.max(maxlen, right-left+1); 
            
        }

        return maxlen;
        
    }
}
