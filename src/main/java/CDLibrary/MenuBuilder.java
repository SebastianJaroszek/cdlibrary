package CDLibrary;

import java.util.ArrayList;
import java.util.List;

public class MenuBuilder {

    private List<MenuItem> menuItems;
    private ScannerUtils scannerUtils;
    private boolean exitItemExsist;

    public MenuBuilder(){
        this.exitItemExsist = false;
        this.menuItems = new ArrayList<>();
    }

    public MenuBuilder addScannerUtils(ScannerUtils scannerUtils){
        this.scannerUtils = scannerUtils;
        return this;
    }

    public MenuBuilder addMenuItem(String message, Runnable action){
        if (exitItemExsist){
            throw new IllegalStateException("Metoda addMenuItem() może być wywołana tylko przed addExitItem().");
        }
        this.menuItems.add(new MenuItem(message, action));
        return this;
    }


    /**
     * Po wywołaniu addExitItem nie można już wywołać addExitItem ani addMenuItem
     * @param exitMessage
     * @return
     */
    public MenuBuilder addExitItem(String exitMessage){
        if (menuItems.isEmpty()){
            throw new IllegalStateException("Najpierw należy użyć metody addMenuItem().");
        }
        if (exitItemExsist){
            throw new IllegalStateException("Metoda addExitItem() może być wywołana tylko raz.");
        }
        this.menuItems.add(new MenuItem(exitMessage, () -> {}));
        this.exitItemExsist = true;
        return this;
    }

    /**
     * Metodę build można wywołać dopiero po addScannerUtils i addExitItem
     * @return
     */
    public Menu build(){
        if (scannerUtils == null){
            throw new IllegalStateException("Metoda build() musi być wywołana po metodzie addScannerUtils()");
        }
        Menu menu = new Menu(scannerUtils);
        menu.setMenuItems(menuItems);
        return menu;
    }
}
