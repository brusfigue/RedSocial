package redsocial;

public class Main {
    public static void main(String[] args) {
        RedSocial redSocial = new RedSocial();
        App app = new App();
        redSocial.runRedSocial();
        app.logMenu(redSocial);
    }
}