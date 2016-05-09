package hu.bme.aut.animalfindapplication.other;

/**
 * Created by Norbert on 2016. 05. 07..
 */
public class MenuItem {
    private String name;
    private FragmentTypeEnum fragmentTypeEnum;
    private int icon;

    public MenuItem(String name, FragmentTypeEnum fragmentTypeEnum, int icon) {
        this.name = name;
        this.fragmentTypeEnum = fragmentTypeEnum;
        this.icon = icon;
    }

    public FragmentTypeEnum getFragmentTypeEnum() {
        return fragmentTypeEnum;
    }

    public void setFragmentTypeEnum(FragmentTypeEnum fragmentTypeEnum) {
        this.fragmentTypeEnum = fragmentTypeEnum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }
}
