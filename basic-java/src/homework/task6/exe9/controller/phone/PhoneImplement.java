package homework.task6.exe9.controller.phone;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneImplement implements PhoneInterface{
    private final String [] phones;
    private int index;
    private final Pattern pattern;
    public PhoneImplement(){
        this.phones = new String[5];
        this.index = 0;
        this.pattern = Pattern.compile("\\d{1,3}-\\d{1,3}-\\d{1,4}");
    }
    public void addPhone(String phone) throws Exception {
        if (this.index != this.phones.length) {
            Matcher matcher = pattern.matcher(phone);
            if (matcher.matches()) {
                this.phones[index] = phone;
                this.index++;
            } else {
                throw new Exception("The phone that you just enter is not valid");
            }
        } else {
            throw new IndexOutOfBoundsException("You are only allowed to add 5 phones");
        }
    }
    public void setPhone(String oldPhone, String newPhone){
        for (int i = 0; i < this.index + 1; i++) {
            if (this.phones[i].equals(oldPhone)){
                this.phones[i] = newPhone;
                break;
            }
        }
    }
    public void deletePhone(String phone){
        for (int i = 0; i < this.index + 1; i++) {
            if (this.phones[i].equals(phone)){
                for (int j = i; j < this.index; j++ ){
                    this.phones[j] = this.phones[j + 1];
                }
                this.index--;
                break;
            }
        }
    }
    public String[] getPhones() {
        return Arrays.copyOfRange(this.phones, 0, this.index);
    }
}
