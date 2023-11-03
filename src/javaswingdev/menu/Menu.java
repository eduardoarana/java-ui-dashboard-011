package javaswingdev.menu;

import com.sun.prism.paint.Gradient;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.ArrayList;
import java.util.List;
import javaswingdev.GoogleMaterialDesignIcon;
import javaswingdev.swing.scroll.ScrollBar;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;

public class Menu extends JPanel {

    private int index = -1;
    private final List<EventMenuSelected> events = new ArrayList<>();

    public Menu() {
        init();
        setOpaque(false);
    }

    private void init() {
        setBackground(Color.WHITE);
        setLayout(new BorderLayout());
        JScrollPane scroll = createScroll();
        panelMenu = createPanelMenu();
        scroll.setViewportView(panelMenu);
        scroll.getViewport().setOpaque(false);
        scroll.setViewportBorder(null);
        add(scroll);
        addTitle("PRINCIPAL");
        addMenuItem(new ModelMenuItem(GoogleMaterialDesignIcon.DASHBOARD, "Farmacia"));
        addTitle("CONEXION FTP");
        addMenuItem(new ModelMenuItem(GoogleMaterialDesignIcon.TOLL, "Mantenimiento", "Configuracion de  Descargas"));
        addMenuItem(new ModelMenuItem(GoogleMaterialDesignIcon.PEOPLE, "Usuario", "Registro de Usuario"));
        addMenuItem(new ModelMenuItem(GoogleMaterialDesignIcon.HOTEL, "Inventario" ,"Inventario" ));// "Aticulo", "Linea", "SibLinea", "Categoria", "Color",
//                "Unidad", "Sucursal", "Almacen", "Procedencia", "Ubicacion", "Tipo de Ajustes", "Tipo de Ajustes", "Proveedor"));
        addTitle("VENTA CXC");
        
        addMenuItem(new ModelMenuItem(GoogleMaterialDesignIcon.INBOX, "FACTURA", "Factura de Ventas" , "Pedido")); //"Cotizacion", "Devolucion",
//                "Nota de Entrega","Despacho","Cliente" ,"Tipo","Zona","Segmento" ,"Pais","Sucursal","Transporte" ));
//        addMenuItem(new ModelMenuItem(GoogleMaterialDesignIcon.DIRECTIONS_BIKE, "Advanced UI", "Cropper", "Owl Carousel", "Sweet Alert"));
//        addMenuItem(new ModelMenuItem(GoogleMaterialDesignIcon.DVR, "Forms", "Basic Elements", "Advanced Elements", "SEditors", "Wizard"));
//        addMenuItem(new ModelMenuItem(GoogleMaterialDesignIcon.PIE_CHART_OUTLINED, "Charts", "Apex", "Flot", "Peity", "Sparkline"));
//        addMenuItem(new ModelMenuItem(GoogleMaterialDesignIcon.VIEW_LIST, "Table", "Basic Tables", "Data Table"));
//        addMenuItem(new ModelMenuItem(GoogleMaterialDesignIcon.INSERT_EMOTICON, "Icons", "Feather Icons", "Flag Icons", "Mdi Icons"));
        addTitle("COMPRA CXP");
        addMenuItem(new ModelMenuItem(GoogleMaterialDesignIcon.INBOX, "FACTURA",
                "",
                "Factura Compras"
         /*       "Cotizacion", "Devolucion",
                "Nota de Recepcion","Proveedor" ,"Tipo","Zona","Segmento" ,"Condicion de  Pago"
        */));
//        addMenuItem(new ModelMenuItem(GoogleMaterialDesignIcon.INBOX, "Special Pages", "Blank page", "Faq", "Invoice", "Profile", "Pricing", "Timeline"));
//        addMenuItem(new ModelMenuItem(GoogleMaterialDesignIcon.LOCK_OUTLINE, "Authentication", "Login", "Register"));
//        addMenuItem(new ModelMenuItem(GoogleMaterialDesignIcon.ERROR_OUTLINE, "Error", "404", "500"));
    }

    private JScrollPane createScroll() {
        JScrollPane scroll = new JScrollPane();
        scroll.setBorder(null);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setVerticalScrollBar(new ScrollBar());
        return scroll;
    }

    private JPanel createPanelMenu() {
        JPanel panel = new JPanel();
        panel.setOpaque(false);
        menuLayout = new MigLayout("wrap,fillx,inset 0,gapy 0", "[fill]");
        panel.setLayout(menuLayout);

        return panel;
    }

    private JPanel createMenuItem(ModelMenuItem item) {
        MenuItem menuItem = new MenuItem(item, ++index, menuLayout);
        menuItem.addEvent(new EventMenuSelected() {
            @Override
            public void menuSelected(int index, int indexSubMenu) {
                if (!menuItem.isHasSubMenu() || indexSubMenu != 0) {
                    clearSelected();
                    setSelectedIndex(index, indexSubMenu);
                }
            }
        });
        return menuItem;
    }

    private void runEvent(int index, int indexSubMenu) {
        for (EventMenuSelected event : events) {
            event.menuSelected(index, indexSubMenu);
        }
    }

    //  Public Method
    public void addMenuItem(ModelMenuItem menu) {
        panelMenu.add(createMenuItem(menu), "h 45!");
    }

    public void addTitle(String title) {
        JLabel label = new JLabel(title);
        label.setBorder(new EmptyBorder(15, 15, 15, 15));
        label.setFont(label.getFont().deriveFont(Font.BOLD));
        label.setForeground(new Color(255, 255, 255));
        panelMenu.add(label);
    }

    public void addSpace(int size) {
        panelMenu.add(new JLabel(), "h " + size + "!");
    }

    public void setSelectedIndex(int index, int indexSubMenu) {
        for (Component com : panelMenu.getComponents()) {
            if (com instanceof MenuItem) {
                MenuItem item = (MenuItem) com;
                if (item.getIndex() == index) {
                    item.setSelectedIndex(indexSubMenu);
                    runEvent(index, indexSubMenu);
                    break;
                }
            }
        }
    }

    public void clearSelected() {
        for (Component com : panelMenu.getComponents()) {
            if (com instanceof MenuItem) {
                MenuItem item = (MenuItem) com;
                item.clearSelected();
            }
        }
    }

    public void addEvent(EventMenuSelected event) {
        events.add(event);
    }

    @Override
    protected void paintChildren(Graphics grphics) {
        Graphics2D g2 = (Graphics2D) grphics;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        GradientPaint g = new GradientPaint(0, 0, Color.decode("#1cB5E0"), 0, getHeight(), Color.decode("#1cB5E0"));
        g2.setPaint(g);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
        super.paintChildren(grphics);
    }

    private MigLayout menuLayout;
    private JPanel panelMenu;
}
