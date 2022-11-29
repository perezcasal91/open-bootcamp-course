package homework.task6.exe9.controller.phone;

public interface PhoneInterface {
    void addPhone(String phone) throws Exception;
    void setPhone(String oldPhone, String newPhone);
    void deletePhone(String phone);
    String[] getPhones();
}
