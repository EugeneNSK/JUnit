public class DBase implements DBaseInt{ //вместо бизнес логики используем интерфес заглушку DBaseInt

    public String find(int id){
        //Бизнес логика для продакшена
        System.out.println("Получили id: " + id );
        if (id<100){
            return "Test name";
        }
        else return null;

    }

    public int save(int id, String s){
        //Бизнес логика для продакшена
        System.out.println("Save: " + id);
        if (id<10) {
            return 1;
        }
        return -1;
    }
}


