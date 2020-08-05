package lesson5;

public class MainHW5 {
    public static void main(String[] args) {
        Staff staff1 = new Staff("Ivan Petrov", "engineer", "IvanP@mail.ru", "+7-654-321-85-74", 40000, 45);
        staff1.staffInfo();

        Staff [] staffArray = new Staff[5];
        staffArray[0] = new Staff("Васиссуалий Карпов", "инжинер", "VaKa@mail.ru", "+7-654-321-85-74", 40000, 30);
        staffArray[1] = new Staff("Владилен Серафимов", "ведущий инжинер", "VlSeP@mail.ru", "+7-654-321-85-75", 45000, 35);
        staffArray[2] = new Staff("Аполлинарий Путятов", "главный инженер", "ApPu@mail.ru", "+7-654-321-85-76", 50000, 45);
        staffArray[3] = new Staff("Капитолина Светозарова", "зам. директора", "KaSv@mail.ru", "+7-454-397-19-74", 80000, 21);
        staffArray[4] = new Staff("Доброжир Ярополков", "директор", "Director@mail.ru", "+7-454-397-19-75", 95000, 61);

        //staffArray[3].staffInfo();

        System.out.println("Сотрудники старше 40 лет:");
        for (int i = 0; i < staffArray.length; i++) {
            staffArray[i].staffOverForty();
        }

    }
}
