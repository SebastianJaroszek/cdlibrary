package CDLibrary;

import java.util.ArrayList;
import java.util.List;

public class MenuBuilder {

    private List<MenuItem> menuItems;
    private ScannerUtils scannerUtils;

    public MenuBuilder(){
        this.menuItems = new ArrayList<>();
    }

    public MenuBuilder addScannerUtils(ScannerUtils scannerUtils){
        this.scannerUtils = scannerUtils;
        return this;
    }

    public MenuBuilder addMenuItem(String message, Runnable action){
        this.menuItems.add(new MenuItem(message, action));
        return this;
    }


    /**
     * Po wywołaniu addExitItem nie można już wywołać addExitItem ani addMenuItem
     * @param exitMessage
     * @return
     */
    public MenuBuilder addExitItem(String exitMessage){
        this.menuItems.add(new MenuItem(exitMessage, () -> {}));
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
