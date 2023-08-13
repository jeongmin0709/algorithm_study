import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class PhoneNumberList {
    public boolean solution(String[] phone_book) {
        Set<String> set = Arrays.stream(phone_book).collect(Collectors.toSet());
        for(String phoneNumber: phone_book){
            for(int i=1; i<phoneNumber.length(); i++){
                if(set.contains(phoneNumber.substring(0, i))) return false;
            }
        }
        return true;
    }
}
