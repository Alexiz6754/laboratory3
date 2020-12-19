public abstract class Person implements Standartable, Emotionable{
    private String name;
    private Gender gender;
    private Emotion emotion;
    private Speed speed;
    private Place place;

    public Person(){
        this.name = "Неизвестно";
        this.gender = Gender.UNKNOWN;
        this.emotion = Emotion.UNKNOWN;
        System.out.println("Кто-то появился");
    }

    public Person(String name,Gender gender, Emotion emotion,Speed speed,Place place,String describe){
        this.name = name;
        this.gender = gender;
        this.emotion = emotion;
        this.speed = speed;
        this.place = place;

        String result;
        if (gender == Gender.MALE)
            result = "появился";
        else
            result = "появилась";

        if (!describe.equals(""))
            System.out.println(name + " " + result + ", " + describe);
        else
            System.out.println(name + " " + result + "!");
    }

    public void changePlace(Place place){
        String genderMsg;
        if (place.canChange()) {
            if (gender == Gender.MALE)
                genderMsg = " попал";
            else
                genderMsg = " попала";

            System.out.println(this.name + genderMsg + " из " + this.place.getName() + " в " + place.getName());
            this.place = place;
        } else {
            if (gender == Gender.MALE)
                genderMsg = "смог попасть";
            else
                genderMsg = "смогла попасть";

            System.out.println(this.name + " не " + genderMsg + " в " + place.getName());
        }
    }

    public void move(){
        String result = this.name + " ";
        if (speed == Speed.CRAWL){
            result += "пополз";
            if (gender != Gender.MALE)
                result += "ла";
        } else if (speed == Speed.RUN){
            result += "побежал";
            if (gender != Gender.MALE)
                result += "а";
        } else if (speed == Speed.BOOST){
            result += "рванул";
            if (gender != Gender.MALE)
                result += "а";
        } else if (speed == Speed.FLY){
            result += "ну, видимо полетел";
            if (gender != Gender.MALE)
                result += "а";
        }
        System.out.println(result);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Speed getSpeed() {
        return speed;
    }

    public void setSpeed(Speed speed) {
        this.speed = speed;
    }

    public Emotion getEmotion() {
        return emotion;
    }

    public void setEmotion(Emotion emotion) {
        this.emotion = emotion;
    }

    public Place getPlace() {
        return place;
    }

    @Override
    public void showEmotion() {
        String result = this.name + " ";
       switch(this.emotion){
           case FUN: result += "задорно смеется"; break;
           case PANIC: result += "уверенно паникует"; break;
           case RAGE: result += "рвет и мечет от ярости"; break;
           case EMBARRASSMENT: result += "краснеет от смущения"; break;
           case CALM:
               if (gender == Gender.MALE)
                   result += "спокоен как скала";
               else if (gender == Gender.FEMALE)
                   result += "спокойна как скала";
               else if (gender == Gender.BETAN)
                   result += "Бетан - удав";
           break;
           case UNKNOWN: result += "не ведает, что такое эмоции"; break;
       }
        System.out.println(result);
    }

    @Override
    public void changeEmotion(Emotion emotion) {
        String result = this.name + " ";
        this.emotion = emotion;
        switch(emotion){
            case FUN: result += "чувствует как клокочет смех"; break;
            case PANIC: result += "чувствует подступающий ужас"; break;
            case RAGE: result += "взрывается гневом"; break;
            case EMBARRASSMENT: result += "реально смущается"; break;
            case CALM: result += "на глазах серьезнеет"; break;
            case UNKNOWN: result += "не понимает, что такое эмоции"; break;
        }
        System.out.println(result);
    }

    @Override
    public String toString() {
        return name + " Emotion:" + emotion.ordinal() + " Gender:" + gender.ordinal();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        return this.hashCode() == obj.hashCode();
    }

    @Override
    public int hashCode() {
        return super.hashCode() + name.hashCode();
    }
}
