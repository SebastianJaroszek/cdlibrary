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

    public Menu build(){
        Menu menu = new Menu(scannerUtils);
        menu.setMenuItems(menuItems);
        return menu;
    }

}
