public class Main {
    public static void main(String[] args) {
        System.out.println("Пришел Седымов А.А. из Р3112");

        World world = new World();
        Room room = new Room();

        Human kid = new Human("Малыш",Gender.MALE,Emotion.UNKNOWN,Speed.CRAWL,world,13,"");
        kid.showEmotion();

        Human karlson = new Human("Карлсон", Gender.MALE,Emotion.CALM,Speed.CRAWL,world,40,"свалившись на Малыша");
        kid.changeEmotion(Emotion.FUN);
        karlson.showEmotion();

        Betan betan = new Betan("Бетан",Gender.BETAN,Emotion.EMBARRASSMENT,Speed.RUN,world,"стреляя глазами");

        kid.move();
        karlson.move();
        betan.move();

        kid.changeEmotion(Emotion.PANIC);
        karlson.changeEmotion(Emotion.PANIC);
        kid.setSpeed(Speed.BOOST);
        karlson.setSpeed(Speed.BOOST);

        betan.toCatch(kid,karlson);

        kid.changePlace(room);
        karlson.changePlace(room);
        room.changeState(karlson);
        karlson.changeEmotion(Emotion.FUN);

        betan.changePlace(room);
        betan.banging(room);
        betan.showEmotion();
        //
    }
}
