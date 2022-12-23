package homework.task7.ui;

import homework.task7.controller.CarImplement;
import homework.task7.controller.CarInterface;
import homework.task7.model.Car;
import homework.task7.model.CarSize;
import homework.task7.model.CarWeightOrSpeed;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.util.List;
import java.util.Objects;

public class CarUI extends JDialog {
    private JPanel contentPane;
    private JPanel panel1;
    private JPanel panel2;
    private JButton addButton;
    private JButton updateButton;
    private JButton deleteButton;
    private JButton cancelButton;
    private JLabel colorLabel;
    private JTextField colorTextField;
    private JLabel manufacturerLabel;
    private JTextField manufacturerTextField;
    private JLabel modelLabel;
    private JTextField modelTextField;
    private JLabel weightLabel;
    private JSpinner weightSpinner;
    private JComboBox weightComboBox;
    private JLabel sizeLabel;
    private JSpinner sizeLengthSpinner;
    private JSpinner sizeWidthSpinner;
    private JLabel speedLabel;
    private JSpinner speedSpinner;
    private JComboBox speedComboBox;
    private JPanel panel3;
    private JTable tableList;
    private JScrollPane tableScrollPane;
    private Object [][] tableValues;
    private String[] tableNames;
    private CarInterface carInterface;
    private DefaultTableModel defaultTableModel;
    private int id;
    private int row;
    private Car selectedCar;
    public CarUI() {
        setContentPane(this.contentPane);
        setModal(true);
        getRootPane().setDefaultButton(this.cancelButton);
        this.addButton.addActionListener(e -> onAdd());
        this.tableList.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {onClick();}
            @Override
            public void mousePressed(MouseEvent e) {}
            @Override
            public void mouseReleased(MouseEvent e) {}
            @Override
            public void mouseEntered(MouseEvent e) {}
            @Override
            public void mouseExited(MouseEvent e) {}
        });
        this.updateButton.addActionListener(e-> onUpdate());
        this.deleteButton.addActionListener(e-> onDelete());
        this.cancelButton.addActionListener(e -> onCancel());
        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });
        // call onCancel() on ESCAPE
        this.contentPane.registerKeyboardAction(e -> onCancel(), KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0),
                JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }
    // Init Components
    private void initComponents() {
        this.carInterface = new CarImplement();
        fillTableColumnNames();
        fillTableRowValues();
        this.defaultTableModel = new DefaultTableModel(this.tableValues, this.tableNames);
        this.tableList = new JTable(this.defaultTableModel);
        this.id = 1;
        this.row = -1;
    }
    private void fillTableColumnNames() {
        this.tableNames = new String[6];
        this.tableNames[0] = "Color";
        this.tableNames[1] ="Manufacturer";
        this.tableNames[2] ="Model";
        this.tableNames[3] ="Weight";
        this.tableNames[4] ="Size";
        this.tableNames[5] ="Speed";
    }
    private void fillTableRowValues() {
        List<Car> carArrayList = this.carInterface.findAll();
        this.tableValues = new Object[carArrayList.size()][6];
        for (int i = 0; i < this.tableValues.length; i++) {
            Object [] objects = new Object[6];
            objects[0] = carArrayList.get(i);
            objects[1] = carArrayList.get(i).getManufacturer();
            objects[2] = carArrayList.get(i).getModel();
            objects[3] = carArrayList.get(i).getWeight();
            objects[4] = carArrayList.get(i).getSize();
            objects[5] = carArrayList.get(i).getSpeed();
            this.tableValues[i] = objects;
        }
    }
    // On Add
    private void onAdd() {
        String color = this.colorTextField.getText();
        String manufacturer = this.manufacturerTextField.getText();
        String model = this.modelTextField.getText();
        CarWeightOrSpeed weight = getWeight();
        CarSize size = getCarSize();
        CarWeightOrSpeed speed = getSpeed();
        if (isTextFieldEmpty()) {
            if (isNullField(weight, size, speed)) {
                addRow(this.carInterface.createCar(this.id, color, manufacturer, model, weight, size, speed));
            }
        } else {
            JOptionPane.showMessageDialog(this, "The field can't be empty.",
                    "Message", JOptionPane.ERROR_MESSAGE);
        }
    }
    private CarWeightOrSpeed getWeight() {
        Integer value = (Integer)this.weightSpinner.getValue();
        String unit = Objects.requireNonNull(this.weightComboBox.getSelectedItem()).toString();
        if (value > 500 && value < 2000 ) {
            if (this.weightComboBox.getSelectedIndex() != 0) {
                return new CarWeightOrSpeed(value, unit);
            } else {
                JOptionPane.showMessageDialog(this, "You must to select a unit");
            }
        } else {
            JOptionPane.showMessageDialog(this, "The weight has to be between 500 and 2000.");
        }
        return null;
    }
    private CarSize getCarSize() {
        Integer lengthSpinnerValue = (Integer)this.sizeLengthSpinner.getValue();
        Integer widthSpinnerValue = (Integer)this.sizeWidthSpinner.getValue();
        if (lengthSpinnerValue > 0 && widthSpinnerValue > 0) {
            return new CarSize(lengthSpinnerValue, widthSpinnerValue);
        } else {
            JOptionPane.showMessageDialog(this, "The length and width has to be bigger than 0");
        }
        return null;
    }
    private CarWeightOrSpeed getSpeed() {
        Integer value = (Integer)this.speedSpinner.getValue();
        String unit = Objects.requireNonNull(this.speedComboBox.getSelectedItem()).toString();
        if (value > 50 && value < 200 ) {
            if (this.speedComboBox.getSelectedIndex() != 0) {
                return new CarWeightOrSpeed(value, unit);
            } else {
                JOptionPane.showMessageDialog(this, "You must to select a unit");
            }
        }else {
            JOptionPane.showMessageDialog(this, "The speed has to be between 50 and 200.");
        }
        return null;
    }
    private boolean isTextFieldEmpty() {
        boolean color = this.colorTextField.getText().isEmpty();
        boolean manufacturer = this.manufacturerTextField.getText().isEmpty();
        boolean model = this.modelTextField.getText().isEmpty();
        return !(color | manufacturer | model);
    }
    private boolean isNullField(CarWeightOrSpeed weight, CarSize size, CarWeightOrSpeed speed) {
        return weight != null && size != null && speed != null;
    }
    private void addRow(Car car) {
        this.carInterface.saveCar(car);
        Object [] object = new Object[6];
        object[0] = car;
        object[1] = car.getManufacturer();
        object[2] = car.getModel();
        object[3] = car.getWeight();
        object[4] = car.getSize();
        object[5] = car.getSpeed();
        this.defaultTableModel.addRow(object);
        this.id++;
        clearField();
        JOptionPane.showMessageDialog(this, "Added successfully");
    }
    private void clearField() {
        this.colorTextField.setText("");
        this.manufacturerTextField.setText("");
        this.modelTextField.setText("");
        this.weightSpinner.setValue(0);
        this.weightComboBox.setSelectedIndex(0);
        this.sizeLengthSpinner.setValue(0);
        this.sizeWidthSpinner.setValue(0);
        this.speedSpinner.setValue(0);
        this.speedComboBox.setSelectedIndex(0);
    }
    private void onClick() {
        this.row = this.tableList.getSelectedRow();
        if (this.row != -1) {
            this.selectedCar = (Car) this.defaultTableModel.getValueAt(this.tableList.getSelectedRow(), 0);
            filField(this.selectedCar);
        }
    }
    private void filField(Car car) {
        this.colorTextField.setText(car.getColor());
        this.manufacturerTextField.setText(car.getManufacturer());
        this.modelTextField.setText(car.getModel());
        this.weightSpinner.setValue(car.getWeight().getValue());
        this.weightComboBox.setSelectedItem(car.getWeight().getUnit());
        this.sizeLengthSpinner.setValue(car.getSize().getLength());
        this.sizeWidthSpinner.setValue(car.getSize().getWidth());
        this.speedSpinner.setValue(car.getSpeed().getValue());
        this.speedComboBox.setSelectedItem(car.getSpeed().getUnit());
    }
    private void onUpdate() {
        if (this.row != -1) {
            String color = this.colorTextField.getText();
            String manufacturer = this.manufacturerTextField.getText();
            String model = this.modelTextField.getText();
            CarWeightOrSpeed weight = getWeight();
            CarSize size = getCarSize();
            CarWeightOrSpeed speed = getSpeed();
            if (isTextFieldEmpty()) {
                if (isNullField(weight, size, speed)) {
                    updateRow(this.carInterface.updateCar(this.selectedCar, color,
                            manufacturer, model, weight, size, speed));
                    this.row = -1;
                }
            } else {
                JOptionPane.showMessageDialog(this, "The field can't be empty.",
                        "Message", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            onDeleteAndUpdateMessage();
        }
    }
    private void onDeleteAndUpdateMessage() {
        JOptionPane.showMessageDialog(this, "You must select a row",
                "Message", JOptionPane.ERROR_MESSAGE);
    }
    private void updateRow(Car car){
        deleteRow();
        insertRow(car);
        clearField();
        JOptionPane.showMessageDialog(this, "Updated successfully");
    }
    private void insertRow(Car car) {
        Object [] object = new Object[6];
        object[0] = car;
        object[1] = car.getManufacturer();
        object[2] = car.getModel();
        object[3] = car.getWeight();
        object[4] = car.getSize();
        object[5] = car.getSpeed();
        this.defaultTableModel.insertRow(this.row, object);
    }

    private void onDelete() {
        if (this.row != -1) {
            deleteRow();
            this.row = -1;
        } else {
            onDeleteAndUpdateMessage();
        }
    }
    private void deleteRow() {
        this.carInterface.deleteCar(this.selectedCar);
        this.defaultTableModel.removeRow(this.row);
        clearField();
    }
    private void onCancel() {
        dispose();
    }
    private void createUIComponents() {
        initComponents();
    }
}
