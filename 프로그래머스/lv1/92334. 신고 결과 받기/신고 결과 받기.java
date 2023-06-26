import java.util.*;
import java.io.*;
class Solution {
    public int[] solution(String[] idList, String[] report, int k) {
      int[] answer = new int[idList.length];
      HashMap<String, HashSet<String>> reporterInfoMap = new HashMap<>();
      HashMap<String, Integer> reportedCountInfoMap = new HashMap<>();
        
      for(String reportInfo : report){
          String reporter = reportInfo.split(" ")[0]; 
          String reported = reportInfo.split(" ")[1];  
          boolean flag = false;
            
          if(reporterInfoMap.containsKey(reporter)){
              if(reporterInfoMap.get(reporter).contains(reported)){
                  flag = true;
              } else {
                  reporterInfoMap.get(reporter).add(reported);    
              }
          } else {
              reporterInfoMap.put(reporter, new HashSet<String>(){{
                  add(reported);
              }});
          }
            
          if (flag) {
              continue;
          } else if (reportedCountInfoMap.containsKey(reported)){
              reportedCountInfoMap.put(reported, reportedCountInfoMap.get(reported)+1);
          } else {
              reportedCountInfoMap.put(reported, 1);
          }
      }
        
      for (String reported : reportedCountInfoMap.keySet()){
          int reportedCount = reportedCountInfoMap.get(reported);
          if(reportedCount >= k){
              for(int i=0; i<idList.length; i++){
                  if(reporterInfoMap.get(idList[i]) == null){
                      answer[i] = 0;
                  } else if(reporterInfoMap.get(idList[i]).contains(reported)){
                      answer[i]++;
                  }
              }
          }
      }
      return answer;
    }
}