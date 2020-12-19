public class Room extends Place implements Openable{
    {
        System.out.println("Появилась комната!");
    }

    public Room() {
        super("Комната",true);
    }

    public Room(String name,boolean state){
        super(name,state);
    }

    public void changeState(Person person){
        if (this.getState()){
            System.out.println(person.getName() + " закрыл дверь");
        } else {
            System.out.println(person.getName() + " открыл дверь");
        }
        this.setState(!this.getState());
    }

    @Override
    public void describe() {
        System.out.println("Красивая комната Малыша, все как по книжке, канонично");
    }
}
