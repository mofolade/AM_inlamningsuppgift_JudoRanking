package com.company;

public class Task {

    public static <T extends HasDescription> void showMenuAndGetChoice(T[] menuItems){
        View view = View.getInstance();
        // System.out.println("\nSubmenu\n");
        for (int i=0; i<menuItems.length; i++){
            System.out.print(" "+menuItems[i].getDescription());
        }
        view.showMessage("\n"+view.makeAChoiceLabel);
    }

    public static <T extends HasDescription> T GetChoice(T[] menuItems, int choiceIndex){
        return menuItems[choiceIndex];
    }
}
