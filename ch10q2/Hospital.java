/*
You are working with a hospital to develop a patient monitoring system.
The technology they use is very old. 
From their computer you can get a string with "h" for heartbeat and "i" for IV drip. 
Their computer will also give you a number, indicating the amount of time elapsed (in seconds) while taking the string of readings.

* A good enough pulse rate is 50 beats per minute.

* A pulse of less than that is red alert, return value 2.

* A good rate for the IV system is at least 1.5 drips every heartbeat. 

* If the system is not averaging 1.5 drips per heartbeat in the data collection window, 
that is automatically a yellow alert (return value 1). 

* If the pulse is at least 50bpm and the iv rate is 
at least 1.5 drips per heartbeat, then the condition is stable (return value 0).

* The hospital system is a little buggy. Sometimes it will emit
`iiih...hiii`. Any sequence of `iiih` means that the system has
entered a faulty state and is emitting bad data until after the next
`hiii` string. Those garbage strings should be removed from input
before processing.

 */

public class Hospital {
  public static String splitter(String data) { 
     String x = data;  
     String update = ""; 
     int c = x.indexOf("iiih"); 
     int d = x.indexOf("hiii"); 
     if (d == -1 || c == -1) { 
       return x; 
     }
     for (int i = 0; i < data.length(); i++) { 
       int a = x.indexOf("iiih"); 
       int b = x.indexOf("hiii");
       if (b == -1 || a == -1) { 
         update = update;
       } else if (a < b) { 
         update = update + x.substring(0, a) + x.substring(b + 4); 
         x = x.substring(b+4);
       } else if (b < a) { 
         update = update + x.substring(0, a - b); 
         String inter = x.substring(a-b); 
         x = inter;
       } 
     } 
     return update; 
  }
  
  public static double[] count(String update) { 
    double beats = 0; 
    double iv = 0; 
    for (int i = 0; i < update.length(); i++) { 
      String z = update.substring(i, i+1); 
      if (z.equals("i")) { 
        iv++; 
      } else if (z.equals("h")) { 
        beats++; 
      } 
    } 
    double[] result = {beats, iv};
    return result;
  }
  
  public static int check(double iv, double beats, int secs) {     
    double ivh = beats * 3.0 / 2.0; 
    double time = secs;
    double bpm = beats / time; 
    double baseline = 50.0/60.0;
    if (bpm < baseline) { 
      return 2; 
    } else if (iv < ivh) { 
      return 1; 
    } else { 
      return 0; 
    } 
  }
  
  public static int analyze(String data, int secs) {
    String update = splitter(data); 
    double[] ace = count(update); 
    double beats = ace[0]; 
    double iv = ace[1];
    int answer = check(iv, beats, secs);
    return answer;
    
    /*
    String x = data;  
    String update = ""; 
    double beats = 0; 
    double iv = 0; 
    for (int i = 0; i < data.length(); i++) { 
      int a = x.indexOf("iiih"); 
      int b = x.indexOf("hiii");
      if (a < b) { 
        update = x.substring(0, a) + x.substring(b + 4); 
      } else if (b > a) { 
        update = x.substring(b + 4); 
      } 
    }
    for (int i = 0; i < update.length(); i++) { 
      String z = update.substring(i, i+1); 
      if (z.equals("i")) { 
        iv++; 
      } else if (z.equals("h")) { 
        beats++; 
      } 
    } 
    double ivh = beats * 3.0 / 2.0; 
    double time = secs;
    double bpm = beats / time; 
    double baseline = 50.0/60.0;
    if (bpm < baseline) { 
      return 2; 
    } else if (iv < ivh) { 
      return 1; 
    } else { 
      return 0; 
    } 
// paste your code here, or call your own function somehow
        //return HospitalSolution.analyze(data,secs);
  */
  }
}
    
