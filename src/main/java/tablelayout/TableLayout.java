package tablelayout;

import tablelayout.SwingToolkit.DebugRect;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

class TableLayout extends BaseTableLayout<Component, Table, TableLayout, SwingToolkit> {
    ArrayList<DebugRect> debugRects;

    public TableLayout() {
        super((SwingToolkit) SwingToolkit.instance);
    }

    public TableLayout(SwingToolkit toolkit) {
        super(toolkit);
    }

    public void layout() {
        Table table = getTable();
        Insets insets = table.getInsets();
        super.layout(insets.left, insets.top, //
                table.getWidth() - insets.left - insets.right, //
                table.getHeight() - insets.top - insets.bottom);

        List<Cell> cells = getCells();
        for (Cell c : cells) {
            if (c.getIgnore()) continue;
            Component component = (Component) c.getWidget();
            if (component != null) {
                component.setLocation((int) c.getWidgetX(), (int) c.getWidgetY());
                component.setSize((int) c.getWidgetWidth(), (int) c.getWidgetHeight());
            }
        }

        if (getDebug() != Debug.none) SwingToolkit.startDebugTimer();
    }

    public void invalidate() {
        super.invalidate();
        if (getTable().isValid()) getTable().invalidate();
    }

    public void invalidateHierarchy() {
        if (getTable().isValid()) getTable().invalidate();
    }

    void drawDebug() {
        Graphics2D g = (Graphics2D) getTable().getGraphics();
        if (g == null) return;
        g.setColor(Color.red);
        for (DebugRect rect : debugRects) {
            if (rect.type == Debug.cell) g.setColor(Color.red);
            if (rect.type == Debug.widget) g.setColor(Color.green);
            if (rect.type == Debug.table) g.setColor(Color.blue);
            g.drawRect(rect.x, rect.y, rect.width, rect.height);
        }
    }
}