public class BLogic {

    public int editItem(int id, String newName, DBaseInt db){ //интерфейс вместо прямой реализации DBase
        System.out.println("Edit item " + id);
        String itemName = db.find(id);
        if (itemName!=null){
            itemName=newName;
            int res = db.save(id,itemName);
            if (res==2){
                System.out.println("res=2");
            }
        }
        else throw new IllegalArgumentException("record with " + id+ "not good");
        return 1;
    }

}
