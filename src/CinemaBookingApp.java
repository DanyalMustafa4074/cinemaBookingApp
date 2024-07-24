import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


class BackgroundPanel extends JPanel {
    private Image backgroundImage;

    // Constructor to set the background image
    public BackgroundPanel(Image image) {
        this.backgroundImage = image;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Draw the background image
        g.drawImage(backgroundImage, 0, 0, this.getWidth(), this.getHeight(), this);
    }
}


public class CinemaBookingApp extends JFrame {
    private List<String> bookedTickets = new ArrayList<>();
    private Map<String, String> movies = new HashMap<>();
    private Map<String, Integer> availableSeats = new HashMap<>();
    JTextField cnicField;

    public CinemaBookingApp() {
        setTitle("Fizzy Flicks Theater");
        ImageIcon icon = new ImageIcon("D:\\2ND-SEMESTER\\OOP IN JAVA\\PROJECT\\SHOWN TO SIR\\Cinema Booking App\\cinema.jpg");
        setIconImage(icon.getImage());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1100, 700);
        setLocationRelativeTo(null);
        setResizable(false);
        initializeMovies();
        initializeSeats();
        setContentPane(createMainMenuPanel());
    }


    private void initializeMovies() {
        // Comedy movies
        movies.put("comedy 1", "A fun and hilarious movie.");
        movies.put("Comedy 2", "A romantic comedy.");
        movies.put("Comedy 3", "A comedy-drama.");
        movies.put("Comedy 4", "A stand-up comedy special.");
        movies.put("Comedy 5", "An animated comedy.");

        // Action movies
        movies.put("Action 1", "A high-octane action film.");
        movies.put("Action 2", "A superhero action movie.");
        movies.put("Action 3", "A spy action thriller.");
        movies.put("Action 4", "A classic action film.");
        movies.put("Action 5", "A martial arts action movie.");

        // Horror movies
        movies.put("Horror 1", "A spine-chilling horror movie.");
        movies.put("Horror 2", "A psychological horror film.");
        movies.put("Horror 3", "A supernatural horror movie.");
        movies.put("Horror 4", "A classic horror film.");
        movies.put("Horror 5", "A slasher horror movie.");
    }

    private void initializeSeats() {
        // Initialize available seats
        availableSeats.put("VIP", 10);
        availableSeats.put("Standard", 10);
        availableSeats.put("Economy", 20);
    }

    private JPanel createMainMenuPanel(){

        Image backgroundImage = new ImageIcon("D:\\2ND-SEMESTER\\OOP IN JAVA\\PROJECT\\SHOWN TO SIR\\Cinema Booking App\\cinema.jpg").getImage();
        BackgroundPanel mainMenu = new BackgroundPanel(backgroundImage);

        // Create the custom panel with the background image
        mainMenu.setLayout(null);

//        JPanel mainMenu = new JPanel();
//        mainMenu.setBackground(new Color(0XC59849));

        JLabel welcomeLabel = new JLabel("Welcome to Fizzy Flicks Theater");
        welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        welcomeLabel.setForeground(new Color(0x420437));
        welcomeLabel.setFont(new Font("Comic Sans MS", Font.ITALIC+Font.BOLD, 27));
        welcomeLabel.setBounds(255, 200, 500, 40);

        JButton bookTicketButton = new JButton("1. Book Ticket");
        bookTicketButton.setBounds(80, 440, 200, 40);
        bookTicketButton.setBackground(new Color(0x19BD9F));
        bookTicketButton.setFont(new Font("Comic Sans MS", Font.ITALIC+Font.BOLD, 16));

        JButton showTicketDetailsButton = new JButton("2. Booked Status");
        showTicketDetailsButton.setBounds(300, 440, 200, 40);
        showTicketDetailsButton.setBackground(new Color(0x19BD9F));
        showTicketDetailsButton.setFont(new Font("Comic Sans MS", Font.ITALIC+Font.BOLD, 16));

        JButton cancelTicketButton = new JButton("3. Cancel Ticket");
        cancelTicketButton.setBounds(570, 440, 200, 40);
        cancelTicketButton.setBackground(new Color(0x19BD9F));
        cancelTicketButton.setFont(new Font("Comic Sans MS", Font.ITALIC+Font.BOLD, 16));

        JButton viewBookedTicketsButton = new JButton("4. Booked Tickets");
        viewBookedTicketsButton.setBounds(785, 440, 200, 40);
        viewBookedTicketsButton.setBackground(new Color(0x19BD9F));
        viewBookedTicketsButton.setFont(new Font("Comic Sans MS", Font.ITALIC+Font.BOLD, 16));

        JButton feedbackButton = new JButton("5. Provide Feedback");
        feedbackButton.setBounds(300, 500, 200, 40);
        feedbackButton.setBackground(new Color(0x19BD9F));
        feedbackButton.setFont(new Font("Comic Sans MS", Font.ITALIC+Font.BOLD, 16));

        JButton adminPanelButton = new JButton("6. Admin Panel");
        adminPanelButton.setBounds(570, 500, 200, 40);
        adminPanelButton.setBackground(new Color(0x19BD9F));
        adminPanelButton.setFont(new Font("Comic Sans MS", Font.ITALIC+Font.BOLD, 16));

        JButton viewAllMoviesButton = new JButton("7. View All Movies");
        viewAllMoviesButton.setBounds(400, 560, 300, 40);
        viewAllMoviesButton.setBackground(new Color(0x19BD9F));
        viewAllMoviesButton.setFont(new Font("Comic Sans MS", Font.ITALIC+Font.BOLD, 16));

        bookTicketButton.addActionListener(new BookTicketListener());
        showTicketDetailsButton.addActionListener(new ShowTicketDetailsListener());
        cancelTicketButton.addActionListener(new CancelTicketListener());
        viewBookedTicketsButton.addActionListener(new ViewBookedTicketsListener());
        feedbackButton.addActionListener(new ProvideFeedbackListener());
        adminPanelButton.addActionListener(new AdminPanelListener());
        viewAllMoviesButton.addActionListener(new ViewAllMoviesListener());

        mainMenu.add(welcomeLabel);
        mainMenu.add(bookTicketButton);
        mainMenu.add(showTicketDetailsButton);
        mainMenu.add(cancelTicketButton);
        mainMenu.add(viewBookedTicketsButton);
        mainMenu.add(feedbackButton);
        mainMenu.add(adminPanelButton);
        mainMenu.add(viewAllMoviesButton);

        return mainMenu;
    }

    private class BookTicketListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            setContentPane(createMovieCategoryPanel());
            revalidate();
        }
    }

    private class ShowTicketDetailsListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            showTicketDetailsPanel();
        }
    }

    private class CancelTicketListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            cancelTicketPanel();
        }
    }

    private class ViewBookedTicketsListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            viewBookedTicketsPanel();
        }
    }

    private class ProvideFeedbackListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            provideFeedbackPanel();
        }
    }

    private class AdminPanelListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            adminPanel();
        }
    }

    private class ViewAllMoviesListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            viewAllMoviesPanel();
        }
    }

    private JPanel createMovieCategoryPanel() {
        Image backgroundImage = new ImageIcon("D:\\2ND-SEMESTER\\OOP IN JAVA\\PROJECT\\SHOWN TO SIR\\Cinema Booking App\\cinema.jpg").getImage();
        BackgroundPanel  categoryMenu = new BackgroundPanel(backgroundImage);
        categoryMenu.setLayout(null);
        categoryMenu.setBounds(0, 0, 1100, 700);

        JLabel selectCategoryLabel = new JLabel("Select Movie Category");
        selectCategoryLabel.setHorizontalAlignment(SwingConstants.CENTER);
        selectCategoryLabel.setBounds(260, 130, 500, 40);
        selectCategoryLabel.setForeground(new Color(0x420437));
        selectCategoryLabel.setFont(new Font("Comic Sans MS", Font.ITALIC+Font.BOLD, 16));

        JButton comedyButton = new JButton("1. Comedy");
        comedyButton.setHorizontalAlignment(SwingConstants.CENTER);
        comedyButton.setForeground(new Color(0x420437));
        comedyButton.setBackground(new Color(0x19BD9F));
        comedyButton.setFont(new Font("Comic Sans MS", Font.ITALIC+Font.BOLD, 16));
        comedyButton.setBounds(420, 180, 200, 30);

        JButton actionButton = new JButton("2. Action");
        actionButton.setHorizontalAlignment(SwingConstants.CENTER);
        actionButton.setForeground(new Color(0x420437));
        actionButton.setBackground(new Color(0x19BD9F));
        actionButton.setFont(new Font("Comic Sans MS", Font.ITALIC+Font.BOLD, 16));
        actionButton.setBounds(420, 220, 200, 30);

        JButton horrorButton = new JButton("3. Horror");
        horrorButton.setHorizontalAlignment(SwingConstants.CENTER);
        horrorButton.setForeground(new Color(0x420437));
        horrorButton.setFont(new Font("Comic Sans MS", Font.ITALIC+Font.BOLD, 16));
        horrorButton.setBackground(new Color(0x19BD9F));
        horrorButton.setBounds(420, 260, 200, 30);

        JButton mainmenu = new JButton("MAIN MENU");
        mainmenu.setHorizontalAlignment(SwingConstants.CENTER);
        mainmenu.setForeground(new Color(0x420437));
        mainmenu.setBackground(new Color(0x19BD9F));
        mainmenu.setFont(new Font("Comic Sans MS", Font.ITALIC+Font.BOLD, 16));
        mainmenu.setBounds(420, 260, 200, 30);

        comedyButton.addActionListener(new ComedyCategoryListener());
        actionButton.addActionListener(new ActionCategoryListener());
        horrorButton.addActionListener(new HorrorCategoryListener());
        mainmenu.addActionListener(new MainMenuListener());

        categoryMenu.add(selectCategoryLabel);
        categoryMenu.add(comedyButton);
        categoryMenu.add(actionButton);
        categoryMenu.add(horrorButton);
        categoryMenu.add(mainmenu);

        return categoryMenu;
    }

    private class ComedyCategoryListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            setContentPane(createMovieSelectionPanel("Comedy", new String[]{"Airplane", "Herapheri", "Dictator", "Idiots", "Poor Things"}));
            revalidate();
        }
    }
    private class MainMenuListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            setContentPane(createMainMenuPanel());
            revalidate();
        }
    }

    private class ActionCategoryListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            setContentPane(createMovieSelectionPanel("Action", new String[]{"Dark Knight", "Inception", "Batman", "Dune", "Aliens"}));
            revalidate();
        }
    }

    private class HorrorCategoryListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            setContentPane(createMovieSelectionPanel("Horror", new String[]{"Ritual", "Forgotten", "Whole Truth", "Anabelle", "Sabrina"}));
            revalidate();
        }
    }

    private JPanel createMovieSelectionPanel(String category, String[] movies) {
        JPanel movieMenu = new JPanel();
        movieMenu.setLayout(null);
        movieMenu.setBounds(0, 0, 1100, 700);

        JLabel selectMovieLabel = new JLabel("Select a Movie from " + category);
        selectMovieLabel.setHorizontalAlignment(SwingConstants.CENTER);
        selectMovieLabel.setForeground(new Color(0x420437));
        selectMovieLabel.setBounds(260, 130, 500, 40);
        selectMovieLabel.setFont(new Font("Comic Sans MS", Font.ITALIC+Font.BOLD, 16));

        for (int i = 0; i < movies.length; i++) {
            JButton movieButton = new JButton(movies[i] + " (10:00 AM - 10:00 PM)");
            movieButton.setBounds(400, 80 + (i * 60), 300, 40);
            movieButton.setForeground(new Color(0x420437));
            movieButton.setBackground(new Color(0x19BD9F));
            movieButton.setFont(new Font("Comic Sans MS", Font.ITALIC+Font.BOLD, 16));
            movieButton.addActionListener(new MovieSelectionListener(movies[i]));
            movieMenu.add(movieButton);
        }

        return movieMenu;
    }

    private class MovieSelectionListener implements ActionListener {
        private String movie;

        public MovieSelectionListener(String movie) {
            this.movie = movie;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            setContentPane(createSeatSelectionPanel(movie));
            revalidate();
        }
    }

    private JPanel createSeatSelectionPanel(String movie) {
        JPanel seatMenu = new JPanel();
        seatMenu.setLayout(null);
        seatMenu.setBounds(0, 0, 1100, 700);

        JLabel selectSeatsLabel = new JLabel("How many seats do you want for " + movie + "?");
        selectSeatsLabel.setForeground(new Color(0x420437));
        selectSeatsLabel.setFont(new Font("Comic Sans MS", Font.ITALIC+Font.BOLD, 12));
        selectSeatsLabel.setHorizontalAlignment(SwingConstants.CENTER);
        selectSeatsLabel.setBounds(400, 20, 300, 30);

        JTextField seatCountField = new JTextField();
        seatCountField.setBounds(450, 80, 200, 30);

        JButton nextButton = new JButton("Next");
        nextButton.setBackground(new Color(0x19BD9F));
        nextButton.setFont(new Font("Comic Sans MS", Font.ITALIC+Font.BOLD, 16));

        nextButton.setBounds(450, 140, 200, 40);
        nextButton.addActionListener(new SeatSelectionListener(movie, seatCountField));

        seatMenu.add(selectSeatsLabel);
        seatMenu.add(seatCountField);
        seatMenu.add(nextButton);

        return seatMenu;
    }


    private class SeatSelectionListener implements ActionListener {
        private String movie;
        private JTextField seatCountField;

        public SeatSelectionListener(String movie, JTextField seatCountField) {
            this.movie = movie;
            this.seatCountField = seatCountField;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                int seatCount = Integer.parseInt(seatCountField.getText());
                if (seatCount > 0) {
                    setContentPane(createCustomerDetailsPanel(movie, seatCount));
                    revalidate();
                } else {
                    showAlert("Invalid Input", "Number of seats must be a positive integer.");
                }
            } catch (NumberFormatException ex) {
                showAlert("Invalid Input", "Please enter a valid number of seats.");
            }
        }
    }

    private JPanel createCustomerDetailsPanel(String movie, int seatCount) {
        JPanel customerDetailsPanel = new JPanel();
        customerDetailsPanel.setLayout(null);
        customerDetailsPanel.setBounds(0, 0, 1100, 700);

        JLabel cnicLabel = new JLabel("CNIC:");
        cnicLabel.setForeground(new Color(0x420437));
        cnicLabel.setFont(new Font("Comic Sans MS", Font.ITALIC+Font.BOLD, 16));
        cnicLabel.setBounds(400, 20, 100, 30);

        cnicField = new JTextField();
        cnicField.setBounds(550, 20, 200, 30);

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setForeground(new Color(0x420437));
        nameLabel.setFont(new Font("Comic Sans MS", Font.ITALIC+Font.BOLD, 16));
        nameLabel.setBounds(400, 70, 100, 30);

        JTextField nameField = new JTextField();
        nameField.setBounds(550, 70, 200, 30);

        JLabel phoneLabel = new JLabel("Phone:");
        phoneLabel.setForeground(new Color(0x420437));
        phoneLabel.setFont(new Font("Comic Sans MS", Font.ITALIC+Font.BOLD, 16));
        phoneLabel.setBounds(400, 120, 100, 30);

        JTextField phoneField = new JTextField();
        phoneField.setBounds(550, 120, 200, 30);

        JButton nextButton = new JButton("Next");
        nextButton.setBounds(500, 180, 100, 40);
        nextButton.setBackground(new Color(0x19BD9F));
        nextButton.setFont(new Font("Comic Sans MS", Font.ITALIC+Font.BOLD, 16));
        nextButton.addActionListener(new CustomerDetailsListener(movie, seatCount, cnicField, nameField, phoneField));

        customerDetailsPanel.add(cnicLabel);
        customerDetailsPanel.add(cnicField);
        customerDetailsPanel.add(nameLabel);
        customerDetailsPanel.add(nameField);
        customerDetailsPanel.add(phoneLabel);
        customerDetailsPanel.add(phoneField);
        customerDetailsPanel.add(nextButton);

        return customerDetailsPanel;
    }


    private class CustomerDetailsListener implements ActionListener {
        private String movie;
        private int seatCount;
        private JTextField cnicField;
        private JTextField nameField;
        private JTextField phoneField;

        public CustomerDetailsListener(String movie, int seatCount, JTextField cnicField, JTextField nameField, JTextField phoneField) {
            this.movie = movie;
            this.seatCount = seatCount;
            this.cnicField = cnicField;
            this.nameField = nameField;
            this.phoneField = phoneField;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            String cnic = cnicField.getText();
            String name = nameField.getText();
            String phone = phoneField.getText();

            if (cnic.isEmpty() || name.isEmpty() || phone.isEmpty() || !isValidInput(cnic, name, phone)) {
                showAlert("Invalid Input", "Fill all fields or check Format.");
            } else {
                setContentPane(createSeatCategoryPanel(movie, seatCount, cnic, name, phone));
                revalidate();
            }
        }
    }
    private boolean isValidInput(String cnic, String name, String phone) {
        // CNIC format: 12345-1234567-1, Name format: Alphabets and spaces only, Phone number format: 11 digits
        return cnic.matches("\\d{5}-\\d{7}-\\d{1}") && name.matches("[a-zA-Z ]+") && phone.matches("\\d{11}");
    }

    private JPanel createSeatCategoryPanel(String movie, int seatCount, String cnic, String name, String phone) {
        JPanel seatCategoryMenu = new JPanel();
        seatCategoryMenu.setLayout(null);
        seatCategoryMenu.setBounds(0, 0, 1100, 700);

        JLabel selectCategoryLabel = new JLabel("Select Seat Category");
        selectCategoryLabel.setHorizontalAlignment(SwingConstants.CENTER);
        selectCategoryLabel.setForeground(new Color(0x420437));
        selectCategoryLabel.setFont(new Font("Comic Sans MS", Font.ITALIC+Font.BOLD, 16));
        selectCategoryLabel.setBounds(400, 20, 300, 30);

        JButton vipButton = new JButton("VIP ($50 per seat)");
        vipButton.setBounds(400, 80, 300, 40);
        vipButton.setBackground(new Color(0x19BD9F));
        vipButton.setFont(new Font("Comic Sans MS", Font.ITALIC+Font.BOLD, 16));

        JButton standardButton = new JButton("Standard ($35 per seat)");
        standardButton.setBackground(new Color(0x19BD9F));
        standardButton.setFont(new Font("Comic Sans MS", Font.ITALIC+Font.BOLD, 16));
        standardButton.setBounds(400, 140, 300, 40);

        JButton economyButton = new JButton("Economy ($20 per seat)");
        economyButton.setBackground(new Color(0x19BD9F));
        economyButton.setFont(new Font("Comic Sans MS", Font.ITALIC+Font.BOLD, 16));
        economyButton.setBounds(400, 200, 300, 40);

        vipButton.addActionListener(new SeatCategoryListener(movie, seatCount, "VIP", 50, cnic, name, phone));
        standardButton.addActionListener(new SeatCategoryListener(movie, seatCount, "Standard", 35, cnic, name, phone));
        economyButton.addActionListener(new SeatCategoryListener(movie, seatCount, "Economy", 20, cnic, name, phone));

        seatCategoryMenu.add(selectCategoryLabel);
        seatCategoryMenu.add(vipButton);
        seatCategoryMenu.add(standardButton);
        seatCategoryMenu.add(economyButton);

        return seatCategoryMenu;
    }

    private class SeatCategoryListener implements ActionListener {
        private String movie;
        private int seatCount;
        private String category;
        private int price;
        private String cnic;
        private String name;
        private String phone;

        public SeatCategoryListener(String movie, int seatCount, String category, int price, String cnic, String name, String phone) {
            this.movie = movie;
            this.seatCount = seatCount;
            this.category = category;
            this.price = price;
            this.cnic = cnic;
            this.name = name;
            this.phone = phone;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            showTicketDetailsPanel(movie, seatCount, category, price, cnic, name, phone);
        }
    }

    private void showTicketDetailsPanel(String movie, int seatCount, String category, int price, String cnic, String name, String phone) {
        JPanel ticketDetailsPanel = new JPanel();
        ticketDetailsPanel.setLayout(null);
        ticketDetailsPanel.setBounds(0, 0, 1100, 700);

        int totalPrice = seatCount * price;

        JLabel ticketDetailsLabel = new JLabel("Ticket Details");
        ticketDetailsLabel.setForeground(new Color(0x420437));
        ticketDetailsLabel.setFont(new Font("Comic Sans MS", Font.ITALIC+Font.BOLD, 16));
        ticketDetailsLabel.setHorizontalAlignment(SwingConstants.CENTER);
        ticketDetailsLabel.setBounds(400, 20, 300, 30);

        JLabel movieLabel = new JLabel("Movie: " + movie);
        movieLabel.setForeground(new Color(0x420437));
        movieLabel.setFont(new Font("Comic Sans MS", Font.ITALIC+Font.BOLD, 16));
        movieLabel.setBounds(400, 80, 300, 30);

        JLabel seatCountLabel = new JLabel("Seats: " + seatCount);
        seatCountLabel.setForeground(new Color(0x420437));
        seatCountLabel.setFont(new Font("Comic Sans MS", Font.ITALIC+Font.BOLD, 16));
        seatCountLabel.setBounds(400, 120, 300, 30);

        JLabel categoryLabel = new JLabel("Category: " + category);
        categoryLabel.setForeground(new Color(0x420437));
        categoryLabel.setFont(new Font("Comic Sans MS", Font.ITALIC+Font.BOLD, 16));
        categoryLabel.setBounds(400, 160, 300, 30);

        JLabel priceLabel = new JLabel("Total Price: $" + totalPrice);
        priceLabel.setForeground(new Color(0x420437));
        priceLabel.setFont(new Font("Comic Sans MS", Font.ITALIC+Font.BOLD, 16));
        priceLabel.setBounds(400, 200, 300, 30);

        JLabel customerLabel = new JLabel("Customer: " + name + " (" + cnic + ", " + phone + ")");
        customerLabel.setForeground(new Color(0x420437));
        customerLabel.setFont(new Font("Comic Sans MS", Font.ITALIC+Font.BOLD, 16));
        customerLabel.setBounds(400, 240, 400, 30);

        JButton confirmButton = new JButton("Confirm Booking");
        confirmButton.setBounds(450, 280, 200, 40);
        confirmButton.setBackground(new Color(0x19BD9F));
        confirmButton.setFont(new Font("Comic Sans MS", Font.ITALIC+Font.BOLD, 16));
        confirmButton.addActionListener(new ConfirmBookingListener(movie, seatCount, category, price, cnic, name, phone));

        ticketDetailsPanel.add(ticketDetailsLabel);
        ticketDetailsPanel.add(movieLabel);
        ticketDetailsPanel.add(seatCountLabel);
        ticketDetailsPanel.add(categoryLabel);
        ticketDetailsPanel.add(priceLabel);
        ticketDetailsPanel.add(customerLabel);
        ticketDetailsPanel.add(confirmButton);

        JButton mainmenu = new JButton("MAIN MENU");
        mainmenu.setBounds(450, 330, 200, 40);
        mainmenu.setBackground(new Color(0x19BD9F));
        mainmenu.setFont(new Font("Comic Sans MS", Font.ITALIC+Font.BOLD, 16));
        mainmenu.addActionListener(new MainMenuListener());
        ticketDetailsPanel.add(mainmenu);

        setContentPane(ticketDetailsPanel);
        revalidate();
    }

    private class ConfirmBookingListener implements ActionListener {
        private String movie;
        private int seatCount;
        private String category;
        private int price;
        private String cnic;
        private String name;
        private String phone;

        public ConfirmBookingListener(String movie, int seatCount, String category, int price, String cnic, String name, String phone) {
            this.movie = movie;
            this.seatCount = seatCount;
            this.category = category;
            this.price = price;
            this.cnic = cnic;
            this.name = name;
            this.phone = phone;

            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter("Booked.txt",true));
                writer.write(this.movie+","+this.seatCount+","+this.category+","+this.price+","+this.cnic+","+this.phone);
                writer.newLine();
                writer.close();

            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (availableSeats.get(category) >= seatCount) {
                bookedTickets.add("Movie: " + movie + ", Seats: " + seatCount + ", Category: " + category + ", Customer: " + name + ", Total Price: $" + (seatCount * price));
                availableSeats.put(category, availableSeats.get(category) - seatCount);
                showAlert("Booking Confirmed", "Your booking has been confirmed.\nTicket Details:\n" + "Movie: " + movie + "\nSeats: " + seatCount + "\nCategory: " + category + "\nCustomer: " + name + "\nTotal Price: $" + (seatCount * price));
                setContentPane(createMainMenuPanel());
                revalidate();
            } else {
                showAlert("Booking Failed", "Not enough seats available in the selected category.");
            }
        }
    }

    private void showTicketDetailsPanel() {

        JPanel panel = new JPanel();

        panel.setLayout(null);
        panel.setBounds(0, 0, 1100, 700);
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel label = new JLabel("Enter Booking ID:", SwingConstants.CENTER);
        label.setForeground(new Color(0x420437));
        label.setFont(new Font("Comic Sans MS", Font.ITALIC+Font.BOLD, 16));
        label.setBounds(400, 20, 300, 30);

        JTextField bookingIdField = new JTextField();
        bookingIdField.setBounds(400, 60, 300, 30);

        JButton showButton = new JButton("Show Ticket Details");
        showButton.setBounds(450, 100, 200, 40);
        showButton.setBackground(new Color(0x19BD9F));
        showButton.setFont(new Font("Comic Sans MS", Font.ITALIC+Font.BOLD, 16));
        showButton.addActionListener(e -> {
            String bookingId = bookingIdField.getText();
            if (bookingId != null && !bookingId.isEmpty() ) {
                JOptionPane.showMessageDialog(null,bookingId+" FOUND");
            } else {
                showAlert("Invalid Input", "Booking ID cannot be empty.");
            }
        });

        panel.add(label);
        panel.add(bookingIdField);
        panel.add(showButton);

        JButton mainmenu = new JButton("MAIN MENU");
        mainmenu.setBounds(450, 150, 200, 40);
        mainmenu.setBackground(new Color(0x19BD9F));
        mainmenu.setFont(new Font("Comic Sans MS", Font.ITALIC+Font.BOLD, 16));
        mainmenu.addActionListener(new MainMenuListener());
        panel.add(mainmenu);

        setContentPane(panel);
        revalidate();
    }


    private void cancelTicketPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(0, 0, 1100, 700);
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel label = new JLabel("Enter Booking ID to Cancel:", SwingConstants.CENTER);
        label.setForeground(new Color(0x420437));
        label.setFont(new Font("Comic Sans MS", Font.ITALIC+Font.BOLD, 16));
        label.setBounds(400, 20, 300, 30);

        JTextField bookingIdField = new JTextField();
        bookingIdField.setBounds(400, 60, 300, 30);

        JButton cancelButton = new JButton("Cancel Ticket");
        cancelButton.setBounds(450, 100, 200, 40);
        cancelButton.setBackground(new Color(0x19BD9F));
        cancelButton.setFont(new Font("Comic Sans MS", Font.ITALIC+Font.BOLD, 16));
        cancelButton.addActionListener(e -> {
            String bookingId = bookingIdField.getText();
            if (bookingId != null && !bookingId.isEmpty()) {
                showAlert("Ticket Cancelled", "Ticket with Booking ID: " + bookingId + " has been cancelled.");
            } else {
                showAlert("Invalid Input", "Booking ID cannot be empty.");
            }
        });

        panel.add(label);
        panel.add(bookingIdField);
        panel.add(cancelButton);

        JButton mainmenu = new JButton("MAIN MENU");
        mainmenu.setBounds(450, 150, 200, 40);
        mainmenu.setBackground(new Color(0x19BD9F));
        mainmenu.setFont(new Font("Comic Sans MS", Font.ITALIC+Font.BOLD, 16));
        mainmenu.addActionListener(new MainMenuListener());
        panel.add(mainmenu);

        setContentPane(panel);
        revalidate();
    }


    private void viewBookedTicketsPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(0, 0, 1100, 700);
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JList<String> bookedTicketsList = new JList<>(bookedTickets.toArray(new String[0]));
        JScrollPane scrollPane = new JScrollPane(bookedTicketsList);
        scrollPane.setBounds(220, 20, 600, 400);

        panel.add(scrollPane);

        JButton mainmenu = new JButton("MAIN MENU");
        mainmenu.setBounds(450, 440, 200, 40);
        mainmenu.setBackground(new Color(0x19BD9F));
        mainmenu.setFont(new Font("Comic Sans MS", Font.ITALIC+Font.BOLD, 16));
        mainmenu.addActionListener(new MainMenuListener());
        panel.add(mainmenu);

        setContentPane(panel);
        revalidate();
    }


    private void provideFeedbackPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(0, 0, 1100, 700);
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel label = new JLabel("Enter your feedback:", SwingConstants.CENTER);
        label.setForeground(new Color(0x420437));
        label.setFont(new Font("Comic Sans MS", Font.ITALIC+Font.BOLD, 16));
        label.setBounds(400, 20, 300, 30);

        JTextArea feedbackArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(feedbackArea);
        scrollPane.setBounds(400, 60, 300, 200);

        JButton submitButton = new JButton("Submit Feedback");
        submitButton.setBackground(new Color(0x19BD9F));
        submitButton.setFont(new Font("Comic Sans MS", Font.ITALIC+Font.BOLD, 16));
        submitButton.setBounds(450, 280, 200, 40);
        submitButton.addActionListener(e -> {
            String feedback = feedbackArea.getText();
            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter("Feedback.txt",true));
                writer.write(feedbackArea.getText());
                writer.newLine();
                writer.close();

            } catch (IOException exp) {
                throw new RuntimeException(exp);
            }
            if (feedback != null && !feedback.isEmpty()) {
                showAlert("Feedback Received", "Thank you for your feedback!");
                feedbackArea.setText("");
            } else {
                showAlert("Invalid Input", "Feedback cannot be empty.");
            }
        });

        panel.add(label);
        panel.add(scrollPane);
        panel.add(submitButton);

        JButton mainmenu = new JButton("MAIN MENU");
        mainmenu.setBounds(450, 330, 200, 40);
        mainmenu.setBackground(new Color(0x19BD9F));
        mainmenu.setFont(new Font("Comic Sans MS", Font.ITALIC+Font.BOLD, 16));
        mainmenu.addActionListener(new MainMenuListener());
        panel.add(mainmenu);

        setContentPane(panel);
        revalidate();
    }


    private void adminPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(0, 0, 1100, 700);
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel seatsLabel = new JLabel("Available Seats:", SwingConstants.CENTER);
        seatsLabel.setForeground(new Color(0x420437));
        seatsLabel.setFont(new Font("Comic Sans MS", Font.ITALIC+Font.BOLD, 16));
        seatsLabel.setBounds(50, 20, 200, 30);

        JList<String> seatsList = new JList<>(availableSeats.entrySet().stream()
                .map(entry -> entry.getKey() + ": " + entry.getValue())
                .toArray(String[]::new));
        JScrollPane scrollPane = new JScrollPane(seatsList);
        scrollPane.setBounds(50, 60, 400, 200);

        JLabel bookedTicketsLabel = new JLabel("Booked Tickets:", SwingConstants.CENTER);
        bookedTicketsLabel.setForeground(new Color(0x420437));
        bookedTicketsLabel.setFont(new Font("Comic Sans MS", Font.ITALIC+Font.BOLD, 16));
        bookedTicketsLabel.setBounds(550, 20, 200, 30);

        JList<String> bookedTicketsList = new JList<>(bookedTickets.toArray(new String[0]));
        JScrollPane bookedScrollPane = new JScrollPane(bookedTicketsList);
        bookedScrollPane.setBounds(550, 60, 500, 200);

        panel.add(seatsLabel);
        panel.add(scrollPane);
        panel.add(bookedTicketsLabel);
        panel.add(bookedScrollPane);

        JButton mainmenu = new JButton("MAIN MENU");
        mainmenu.setBounds(450, 300, 200, 40);
        mainmenu.setBackground(new Color(0x19BD9F));
        mainmenu.setFont(new Font("Comic Sans MS", Font.ITALIC+Font.BOLD, 16));
        mainmenu.addActionListener(new MainMenuListener());
        panel.add(mainmenu);

        setContentPane(panel);
        revalidate();
    }

    private void viewAllMoviesPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(movies.size() + 2, 1, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel label = new JLabel("All Movies", SwingConstants.CENTER);
        label.setForeground(new Color(0x420437));
        label.setFont(new Font("Comic Sans MS", Font.ITALIC+Font.BOLD, 16));


        panel.add(label);
        movies.forEach((movie, description) -> {
            JLabel m = new JLabel(movie + ": " + description);
            m.setForeground(new Color(0x420437));
            m.setFont(new Font("Comic Sans MS", Font.ITALIC+Font.BOLD, 16));
            panel.add( m);
        });

        JButton mainmenu = new JButton("MAIN MENU");
        mainmenu.setBackground(new Color(0x19BD9F));
        mainmenu.setFont(new Font("Comic Sans MS", Font.ITALIC+Font.BOLD, 16));
        mainmenu.addActionListener(new MainMenuListener());
        panel.add(mainmenu);

        setContentPane(panel);
        revalidate();
    }


    private void showAlert(String title, String message) {
        JOptionPane.showMessageDialog(this, message, title, JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CinemaBookingApp app = new CinemaBookingApp();
            app.setVisible(true);
        });
    }
}


