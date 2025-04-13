import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

public class XMLCRUDApp extends JFrame {
    private JTextField filePathField;
    private JTextArea xmlDisplayArea;
    private JTextField tagNameField;
    private JTextField valueField;
    private JButton addButton;
    private JButton updateButton;
    private JButton deleteButton;
    private JButton saveButton;
    private JButton readButton;
    private JList<String> elementList;
    private DefaultListModel<String> listModel;

    private Document document;
    private List<Element> elements;

    public XMLCRUDApp() {
        setTitle("XML CRUD App");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        elements = new ArrayList<>();

        // Panel cho đường dẫn tệp
        JPanel filePathPanel = new JPanel();
        filePathPanel.setLayout(new FlowLayout());
        filePathPanel.add(new JLabel("File Path:"));
        filePathField = new JTextField(30);
        filePathPanel.add(filePathField);
        readButton = new JButton("Read");
        filePathPanel.add(readButton);

        // Panel cho hiển thị XML
        xmlDisplayArea = new JTextArea();
        xmlDisplayArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(xmlDisplayArea);

        // Panel cho các hành động
        JPanel actionPanel = new JPanel();
        actionPanel.setLayout(new GridLayout(4, 2));
        actionPanel.add(new JLabel("Tag Name:"));
        tagNameField = new JTextField();
        actionPanel.add(tagNameField);
        actionPanel.add(new JLabel("Value:"));
        valueField = new JTextField();
        actionPanel.add(valueField);
        addButton = new JButton("Add");
        actionPanel.add(addButton);
        updateButton = new JButton("Update");
        actionPanel.add(updateButton);
        deleteButton = new JButton("Delete");
        actionPanel.add(deleteButton);
        saveButton = new JButton("Save");
        actionPanel.add(saveButton);

        // Panel cho danh sách các phần tử
        listModel = new DefaultListModel<>();
        elementList = new JList<>(listModel);
        elementList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane listScrollPane = new JScrollPane(elementList);

        // Thêm các panel vào frame
        add(filePathPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(actionPanel, BorderLayout.SOUTH);
        add(listScrollPane, BorderLayout.WEST);

        // Thiết lập các hành động
        readButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                readXMLFile();
            }
        });

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addElementToXML();
            }
        });

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateElementInXML();
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteElementFromXML();
            }
        });

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveXMLFile();
            }
        });

        elementList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int index = elementList.getSelectedIndex();
                if (index != -1) {
                    Element selectedElement = elements.get(index);
                    tagNameField.setText(selectedElement.getTagName());
                    valueField.setText(selectedElement.getTextContent());
                }
            }
        });
    }

    private void readXMLFile() {
        try {
            String filePath = filePathField.getText();
            document = XMLFileHandler.readXML(filePath);
            xmlDisplayArea.setText(XMLFileHandler.documentToString(document));
            updateElementList();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void addElementToXML() {
        if (document != null) {
            String tagName = tagNameField.getText();
            String value = valueField.getText();
            Element newElement = XMLFileHandler.addElement(document, tagName, value);
            elements.add(newElement);
            listModel.addElement(tagName);
            xmlDisplayArea.setText(XMLFileHandler.documentToString(document));
        }
    }

    private void updateElementInXML() {
        int index = elementList.getSelectedIndex();
        if (index != -1) {
            Element selectedElement = elements.get(index);
            selectedElement.setTextContent(valueField.getText());
            listModel.set(index, tagNameField.getText());
            xmlDisplayArea.setText(XMLFileHandler.documentToString(document));
        }
    }

    private void deleteElementFromXML() {
        int index = elementList.getSelectedIndex();
        if (index != -1) {
            Element selectedElement = elements.get(index);
            elements.remove(index);
            listModel.remove(index);
            XMLFileHandler.deleteElement(document, selectedElement.getTagName());
            xmlDisplayArea.setText(XMLFileHandler.documentToString(document));
        }
    }

    private void saveXMLFile() {
        try {
            String filePath = filePathField.getText();
            XMLFileHandler.saveXML(document, filePath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void updateElementList() {
        elements.clear();
        listModel.clear();
        Element root = document.getDocumentElement();
        NodeList nodeList = root.getChildNodes();
        for (int i = 0; i < nodeList.getLength(); i++) {
            if (nodeList.item(i) instanceof Element) {
                Element element = (Element) nodeList.item(i);
                elements.add(element);
                listModel.addElement(element.getTagName());
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new XMLCRUDApp().setVisible(true);
            }
        });
    }
}