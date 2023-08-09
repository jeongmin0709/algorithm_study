import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Hotel {
    public int solution(String[][] book_time) {
        List<BookTime> bookTimes = new ArrayList<>();
        int room = 0;
        int answer = -1;
        for(String[] times: book_time){
            bookTimes.add(new BookTime("start", times[0]));
            bookTimes.add(new BookTime("end", times[1]));
        }
        Collections.sort(bookTimes);
        for(BookTime bookTime: bookTimes){
            if(bookTime.type.equals("start")) room++;
            else room--;
            if(room > answer) answer = room;
        }
        return answer;
    }
    static class BookTime implements Comparable<BookTime>{
        public String type;
        public LocalTime time;
        public BookTime(String type, String time){
            this.type = type;
            if(type.equals("end")) this.time = LocalTime.parse(time, DateTimeFormatter.ofPattern("HH:mm")).plusMinutes(10l);
            else this.time = LocalTime.parse(time, DateTimeFormatter.ofPattern("HH:mm"));
        }
        @Override
        public int compareTo(BookTime bookTime) {
            int i = this.time.compareTo(bookTime.time);
             if(i == 0) return (this.type.equals("end") )?-1:1;
            return i;
        }
    }
}
