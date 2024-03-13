// Main.java

import org.example.Book;
import org.example.Database;

import  javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.NumberFormatter;
import javax.xml.crypto.Data;
import java.awt.*;
import  java.awt.event.*;
import java.text.NumberFormat;
import java.util.ArrayList;

public class Main {
    private JButton LibrarianLogin;
    private JButton UserLogin;

    public Main() {
        JFrame frame = new JFrame("Login");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        LibrarianLogin = new JButton("Librarian Login");
        LibrarianLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame loginFrame = new JFrame("Librarian Login");
                loginFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                loginFrame.setLayout(new FlowLayout());

                JPanel panel = new JPanel();
                panel.setLayout(new GridLayout(4, 2)); // Adjust as needed

                JLabel usernameLabel = new JLabel("Username:");
                JTextField usernameField = new JTextField(5); // Adjust size as needed
                JButton loginButton = new JButton("Login");
                JLabel hintLabel=new JLabel("Username is admin");

                loginButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if(usernameField.getText().equals("admin")){
                        JFrame librarianFrame=new JFrame("Librarian Panel");
                        librarianFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                        librarianFrame.setLayout(new FlowLayout());
                        JPanel panel=new JPanel();
                        panel.setLayout(new GridLayout(5,5));

                        JButton BookCollection=new JButton("Book Collection");
                        BookCollection.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                JFrame bookCollectionFrame=new JFrame("All Books");
                                bookCollectionFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                                bookCollectionFrame.setLayout(new FlowLayout());

                                JTable table = new JTable();
                                DefaultTableModel model = new DefaultTableModel();

                                // Add columns to the model
                                model.addColumn("Title");
                                model.addColumn("Author");
                                model.addColumn("Genre");
                                model.addColumn("Availability");
                                model.addColumn("Book ID");


                                ArrayList<Book> books=new ArrayList<>();
                                books=Database.getBookCollection();
                                for (Book book : books) {
                                    Object[] row = {book.getTitle(), book.getAuthor(), book.getGenre(), book.getAvailability(), book.getBookId()};
                                    model.addRow(row);
                                }

                                // Set model to JTable
                                table.setModel(model);

                                // Add JScrollPane to JFrame
                                JScrollPane scrollPane = new JScrollPane(table);
                                bookCollectionFrame.add(scrollPane, BorderLayout.CENTER);

                                bookCollectionFrame.setSize(600,400);
                                bookCollectionFrame.setVisible(true);
                            }
                        });


                        JButton addNewBookButton=new JButton("Add New Book");
                        addNewBookButton.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                JFrame bookAdditionFrame=new JFrame("Add Book");
                                bookAdditionFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                                bookAdditionFrame.setLayout(new FlowLayout());

                                JPanel bookAdditionPanel=new JPanel();
                                bookAdditionPanel.setLayout(new GridLayout(10,5));

                                JLabel titleLabel=new JLabel("Title:");
                                JTextField titleField=new JTextField();
                                JLabel authorLabel=new JLabel("Author:");
                                JTextField authorField=new JTextField();
                                JLabel genreLabel=new JLabel("Genre:");
                                JTextField genreField=new JTextField();
                                JButton submitButton=new JButton("Submit");
                                submitButton.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        JFrame popupMsg=new JFrame("Dialog Box");
                                        popupMsg.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                                        popupMsg.setLayout(new FlowLayout());

                                        JPanel popupMsgPanel=new JPanel();
                                        popupMsgPanel.setLayout(new GridLayout(2,2));

                                        JLabel successOrErrorMsg=new JLabel("Hello");
                                        if(Database.bookAddition(titleField.getText(),authorField.getText(),genreField.getText()))
                                            successOrErrorMsg.setText("Successfully created book");
                                        else
                                            successOrErrorMsg.setText("Failed to create a book. Try Again Later.");

                                        popupMsgPanel.add(successOrErrorMsg);
                                        popupMsg.add(popupMsgPanel);
                                        popupMsg.pack();
                                        popupMsg.setVisible(true);
                                    }
                                });


                                bookAdditionPanel.add(titleLabel);
                                bookAdditionPanel.add(titleField);
                                bookAdditionPanel.add(authorLabel);
                                bookAdditionPanel.add(authorField);
                                bookAdditionPanel.add(genreLabel);
                                bookAdditionPanel.add(genreField);
                                bookAdditionPanel.add(submitButton);

                                bookAdditionFrame.add(bookAdditionPanel);
                                bookAdditionFrame.pack();
                                bookAdditionFrame.setVisible(true);
                            }
                        });


                        JButton addNewUserButton=new JButton("Add New User");
                        addNewUserButton.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                JFrame userAdditionFrame=new JFrame("Add Book");
                                userAdditionFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                                userAdditionFrame.setLayout(new FlowLayout());

                                JPanel userAdditionPanel=new JPanel();
                                userAdditionPanel.setLayout(new GridLayout(10,5));

                                JLabel nameLabel=new JLabel("Name:");
                                JTextField nameField=new JTextField();
                                JLabel contactLabel=new JLabel("Contact Info:");
                                JTextField contactField=new JTextField();
                                JButton submitButton=new JButton("Submit");
                                submitButton.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        JFrame popupMsg=new JFrame("Dialog Box");
                                        popupMsg.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                                        popupMsg.setLayout(new FlowLayout());

                                        JPanel popupMsgPanel=new JPanel();
                                        popupMsgPanel.setLayout(new GridLayout(2,2));

                                        JLabel successOrErrorMsg=new JLabel("Hello");
                                        if(Database.userAddition(nameField.getText(),contactField.getText()))
                                            successOrErrorMsg.setText("Successfully created book");
                                        else
                                            successOrErrorMsg.setText("Failed to create a book. Try Again Later.");

                                        popupMsgPanel.add(successOrErrorMsg);
                                        popupMsg.add(popupMsgPanel);
                                        popupMsg.pack();
                                        popupMsg.setVisible(true);
                                    }
                                });


                                userAdditionPanel.add(nameLabel);
                                userAdditionPanel.add(nameField);
                                userAdditionPanel.add(contactLabel);
                                userAdditionPanel.add(contactField);
                                userAdditionPanel.add(submitButton);

                                userAdditionFrame.add(userAdditionPanel);
                                userAdditionFrame.pack();
                                userAdditionFrame.setVisible(true);

                            }
                        });



                        JButton returningBooksButton=new JButton("Returning Books");
                        returningBooksButton.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                JFrame returnFrame=new JFrame("Return a Book");
                                returnFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                                returnFrame.setLayout(new FlowLayout());

                                JPanel returnPanel=new JPanel();
                                returnPanel.setLayout(new GridLayout(5,5));

                                JLabel bookIdLabel=new JLabel("Book Id:");
                                JTextField bookIdField=new JTextField();
                                bookIdField.addKeyListener(new IntegerInputKeyListener());
                                JLabel userIdLabel=new JLabel("User Id: ");
                                JTextField userIdField=new JTextField();
                                userIdField.addKeyListener(new IntegerInputKeyListener());
                                JButton submitButton=new JButton("Submit");
                                submitButton.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        JFrame popupMsg=new JFrame("Dialog Box");
                                        popupMsg.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                                        popupMsg.setLayout(new FlowLayout());

                                        JPanel popupMsgPanel=new JPanel();
                                        popupMsgPanel.setLayout(new GridLayout(2,2));

                                        JLabel successOrErrorMsg=new JLabel("Hello");
                                        if(Database.returnBook(bookIdField.getText(),userIdField.getText()))
                                            successOrErrorMsg.setText("("+userIdField.getText()+") have returned the Book with id:"+bookIdField.getText());
                                        else
                                            successOrErrorMsg.setText("Failed to return the Book with id: "+bookIdField.getText()+" Try Again Later.");

                                        popupMsgPanel.add(successOrErrorMsg);
                                        popupMsg.add(popupMsgPanel);
                                        popupMsg.pack();
                                        popupMsg.setVisible(true);
                                    }
                                });


                                returnPanel.add(bookIdLabel);
                                returnPanel.add(bookIdField);
                                returnPanel.add(userIdLabel);
                                returnPanel.add(userIdField);
                                returnPanel.add(submitButton);


                                returnFrame.add(returnPanel);
                                returnFrame.pack();
                                returnFrame.setVisible(true);

                            }
                        });



                        JButton searchBooksButton=new JButton("Search Books");
                        searchBooksButton.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                JFrame searchFrame=new JFrame("Search For Books");
                                searchFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                                searchFrame.setLayout(new FlowLayout());

                                JPanel searchPanel=new JPanel();
                                searchPanel.setLayout(new GridLayout(14,1));


                                JLabel titleLabel=new JLabel("By Title: ");
                                JTextField titleField=new JTextField();
                                JButton searchTitleButton=new JButton("Search By Title");
                                searchTitleButton.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        JFrame bookCollectionFrame=new JFrame("All Books");
                                        bookCollectionFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                                        bookCollectionFrame.setLayout(new FlowLayout());

                                        JTable table = new JTable();
                                        DefaultTableModel model = new DefaultTableModel();

                                        // Add columns to the model
                                        model.addColumn("Title");
                                        model.addColumn("Author");
                                        model.addColumn("Genre");
                                        model.addColumn("Availability");
                                        model.addColumn("Book ID");


                                        ArrayList<Book> books=new ArrayList<>();

                                        books=Database.searchForBooksByTitle(titleField.getText());
                                        if(books.size()==0){
                                            JPanel bookCollectionPanel=new JPanel();
                                            bookCollectionPanel.setLayout(new GridLayout(4,4));

                                            JLabel popup=new JLabel("There are no Books by this name. ");

                                            bookCollectionPanel.add(popup);
                                            bookCollectionFrame.add(bookCollectionPanel);
                                            bookCollectionFrame.pack();
                                            bookCollectionFrame.setVisible(true);
                                        }
                                        for (Book book : books) {
                                            Object[] row = {book.getTitle(), book.getAuthor(), book.getGenre(), book.getAvailability(), book.getBookId()};
                                            model.addRow(row);
                                        }

                                        // Set model to JTable
                                        table.setModel(model);

                                        // Add JScrollPane to JFrame
                                        JScrollPane scrollPane = new JScrollPane(table);
                                        bookCollectionFrame.add(scrollPane, BorderLayout.CENTER);

                                        bookCollectionFrame.setSize(600,400);
                                        bookCollectionFrame.setVisible(true);
                                    }
                                });


                                JLabel authorLabel=new JLabel("By Author: ");
                                JTextField authorField=new JTextField();
                                JButton searchAuthorButton=new JButton("Search By Author");

                                searchAuthorButton.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        JFrame bookCollectionFrame=new JFrame("All Books");
                                        bookCollectionFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                                        bookCollectionFrame.setLayout(new FlowLayout());

                                        JTable table = new JTable();
                                        DefaultTableModel model = new DefaultTableModel();

                                        // Add columns to the model
                                        model.addColumn("Title");
                                        model.addColumn("Author");
                                        model.addColumn("Genre");
                                        model.addColumn("Availability");
                                        model.addColumn("Book ID");


                                        ArrayList<Book> books=new ArrayList<>();
                                        books=Database.searchForBooksByAuthor(authorField.getText());
                                        if(books.size()==0){
                                            JPanel bookCollectionPanel=new JPanel();
                                            bookCollectionPanel.setLayout(new GridLayout(4,4));

                                            JLabel popup=new JLabel("There are no Books by this Author. ");

                                            bookCollectionPanel.add(popup);
                                            bookCollectionFrame.add(bookCollectionPanel);
                                            bookCollectionFrame.pack();
                                            bookCollectionFrame.setVisible(true);
                                        }
                                        for (Book book : books) {
                                            Object[] row = {book.getTitle(), book.getAuthor(), book.getGenre(), book.getAvailability(), book.getBookId()};
                                            model.addRow(row);
                                        }

                                        // Set model to JTable
                                        table.setModel(model);

                                        // Add JScrollPane to JFrame
                                        JScrollPane scrollPane = new JScrollPane(table);
                                        bookCollectionFrame.add(scrollPane, BorderLayout.CENTER);

                                        bookCollectionFrame.setSize(600,400);
                                        bookCollectionFrame.setVisible(true);
                                    }
                                });


                                JLabel idLabel=new JLabel("By Id: ");
                                JTextField idField=new JTextField();
                                idField.addKeyListener(new IntegerInputKeyListener());
                                JButton searchIdButton=new JButton("Search By Id");

                                searchIdButton.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        JFrame bookCollectionFrame=new JFrame("All Books");
                                        bookCollectionFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                                        bookCollectionFrame.setLayout(new FlowLayout());

                                        JTable table = new JTable();
                                        DefaultTableModel model = new DefaultTableModel();

                                        // Add columns to the model
                                        model.addColumn("Title");
                                        model.addColumn("Author");
                                        model.addColumn("Genre");
                                        model.addColumn("Availability");
                                        model.addColumn("Book ID");


                                        ArrayList<Book> books=new ArrayList<>();
                                        books=Database.searchForBooksById(idField.getText());
                                        if(books.isEmpty()){
                                            JPanel bookCollectionPanel=new JPanel();
                                            bookCollectionPanel.setLayout(new GridLayout(4,4));

                                            JLabel popup=new JLabel("There are no Books by this Id. ");

                                            bookCollectionPanel.add(popup);
                                            bookCollectionFrame.add(bookCollectionPanel);
                                            bookCollectionFrame.pack();
                                            bookCollectionFrame.setVisible(true);
                                        }
                                        for (Book book : books) {
                                            Object[] row = {book.getTitle(), book.getAuthor(), book.getGenre(), book.getAvailability(), book.getBookId()};
                                            model.addRow(row);
                                        }

                                        // Set model to JTable
                                        table.setModel(model);

                                        // Add JScrollPane to JFrame
                                        JScrollPane scrollPane = new JScrollPane(table);
                                        bookCollectionFrame.add(scrollPane, BorderLayout.CENTER);

                                        bookCollectionFrame.setSize(600,400);
                                        bookCollectionFrame.setVisible(true);
                                    }
                                });



                                searchPanel.add(titleLabel);
                                searchPanel.add(titleField);
                                searchPanel.add(searchTitleButton);
                                searchPanel.add(authorLabel);
                                searchPanel.add(authorField);
                                searchPanel.add(searchAuthorButton);
                                searchPanel.add(idLabel);
                                searchPanel.add(idField);
                                searchPanel.add(searchIdButton);

                                searchFrame.add(searchPanel);
                                searchFrame.pack();
                                searchFrame.setVisible(true);
                            }
                        });

                        panel.add(BookCollection);
                        panel.add(addNewBookButton);
                        panel.add(addNewUserButton);
                        panel.add(returningBooksButton);
                        panel.add(searchBooksButton);
                        librarianFrame.add(panel);
                        librarianFrame.pack();
                        librarianFrame.setVisible(true);

                        }
                        else{
                            hintLabel.setText("You are entering the wrong Username. Please enter `admin`.");
                        }
                    }
                });

                panel.add(hintLabel);

                panel.add(usernameLabel);
                panel.add(usernameField);
                panel.add(loginButton);
                loginFrame.add(panel);
                loginFrame.pack();
                loginFrame.setVisible(true);
            }
        });
        frame.add(LibrarianLogin);
        frame.pack();
        frame.setVisible(true);

        UserLogin = new JButton("User Login");
        UserLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame loginFrame = new JFrame("User Login");
                loginFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                loginFrame.setLayout(new FlowLayout());

                JPanel panel = new JPanel();
                panel.setLayout(new GridLayout(4, 2)); // Adjust as needed

                JLabel usernameLabel = new JLabel("Id:");
                JTextField usernameField = new JTextField(10); // Adjust size as needed
                usernameField.addKeyListener(new IntegerInputKeyListener());
                JButton loginButton = new JButton("Login");
                panel.add(usernameLabel);
                panel.add(usernameField);
                panel.add(loginButton);

                loginButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {

                        if(Database.userLogin(usernameField.getText())){
                            System.out.println("Hello");
                            JFrame userFrame=new JFrame("User Panel");
                            userFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                            userFrame.setLayout(new FlowLayout());

                            JPanel panel=new JPanel();
                            panel.setLayout(new GridLayout(4,4));

                            JButton borrowBooks=new JButton("Borrow Books");

                            borrowBooks.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    JFrame borrowFrame=new JFrame("Borrow Panel");
                                    borrowFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                                    borrowFrame.setLayout(new FlowLayout());

                                    JPanel panel =new JPanel();
                                    panel.setLayout(new GridLayout(4,4));

                                    JLabel borrowLabel=new JLabel("Enter id of the book u wanna borrow");
                                    JTextField borrowId=new JTextField(10);
                                    borrowId.addKeyListener(new IntegerInputKeyListener());
                                    JButton borrowButton=new JButton("Borrow");



                                    borrowButton.addActionListener(new ActionListener() {
                                        @Override
                                        public void actionPerformed(ActionEvent e) {

                                            JFrame popupMsg=new JFrame("Dialog Box");
                                            popupMsg.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                                            popupMsg.setLayout(new FlowLayout());

                                            JPanel popupMsgPanel=new JPanel();
                                            popupMsgPanel.setLayout(new GridLayout(2,2));

                                            JLabel successOrErrorMsg=new JLabel("Hello");
                                            if(Database.borrowBook(borrowId.getText(),(usernameField.getText())))
                                                successOrErrorMsg.setText("You ("+usernameField.getText()+") have Borrowed the Book with id:"+borrowId.getText());
                                            else
                                                successOrErrorMsg.setText("Failed to Borrow the Book with id: "+borrowId.getText()+" Try Again Later.");

                                            popupMsgPanel.add(successOrErrorMsg);
                                            popupMsg.add(popupMsgPanel);
                                            popupMsg.pack();
                                            popupMsg.setVisible(true);
                                        }
                                    });

                                    panel.add(borrowLabel);
                                    panel.add(borrowId);
                                    panel.add(borrowButton);

                                    borrowFrame.add(panel);
                                    borrowFrame.pack();
                                    borrowFrame.setVisible(true);
                                }
                            });


                            JButton bookCollection=new JButton("Book Collection");

                            bookCollection.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    JFrame bookCollectionFrame=new JFrame("All Books");
                                    bookCollectionFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                                    bookCollectionFrame.setLayout(new FlowLayout());

                                    JTable table = new JTable();
                                    DefaultTableModel model = new DefaultTableModel();

                                    // Add columns to the model
                                    model.addColumn("Title");
                                    model.addColumn("Author");
                                    model.addColumn("Genre");
                                    model.addColumn("Availability");
                                    model.addColumn("Book ID");


                                    ArrayList<Book> books=new ArrayList<>();
                                    books=Database.getBookCollection();
                                    for (Book book : books) {
                                        Object[] row = {book.getTitle(), book.getAuthor(), book.getGenre(), book.getAvailability(), book.getBookId()};
                                        model.addRow(row);
                                    }

                                    // Set model to JTable
                                    table.setModel(model);

                                    // Add JScrollPane to JFrame
                                    JScrollPane scrollPane = new JScrollPane(table);
                                    bookCollectionFrame.add(scrollPane, BorderLayout.CENTER);

                                    bookCollectionFrame.setSize(600,400);
                                    bookCollectionFrame.setVisible(true);

                                }
                            });

                            panel.add(bookCollection);
                            panel.add(borrowBooks);

                            userFrame.add(panel);
                            userFrame.pack();
                            userFrame.setVisible(true);
                        }
                        else
                            usernameLabel.setText("Sahi Tarha Login karo");

                    }
                });

                loginFrame.add(panel);
                loginFrame.pack();
                loginFrame.setVisible(true);
            }
        });
        frame.add(UserLogin);

        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Main();
            }
        });
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}


class IntegerInputKeyListener implements KeyListener {
    @Override
    public void keyTyped(KeyEvent e) {
        char c = e.getKeyChar();
        if (!(Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE)) {
            e.consume(); // Consume the event to prevent input
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // No action needed for keyPressed
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // No action needed for keyReleased
    }
}
