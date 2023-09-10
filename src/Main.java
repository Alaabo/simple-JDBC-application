import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static String jdbcURL = "jdbc:postgresql://localhost:5432/PJA";
    public static String jdbcUsername = "postgres";
    public static String jdbcPassword = "";
    public static String update = "UPDATE public.exo1\n" +
            "\tSET  annee=?\n" +
            "\tWHERE titre = 'hamlet';";
    public static String delete = "DELETE FROM public.exo1\n" +
            "\tWHERE titre = 'la faim';";
    public static void main(String[] args) throws ClassNotFoundException {
        List<books> books = new ArrayList<>();
        Class.forName("org.postgresql.Driver");
//        showing results
        try (Connection connection = DriverManager
                .getConnection(jdbcURL, jdbcUsername, jdbcPassword);
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT auteur, titre, annee\n" +
                     "\tFROM public.exo1 where annee < 1850;");) {
            ResultSet rs = preparedStatement.executeQuery();
            books u;
            while (rs.next()) {
                String auteur = rs.getString("auteur");
                String titre = rs.getString("titre");
                int annee = rs.getInt("annee");
                u = new books(auteur , titre , annee);
                u.setAuteur(auteur);
                u.setTitre(titre);
                u.setAnnee(annee);
                books.add(u);
            }
            System.out.println("results are : \nauteur   titre   annee");
            for (books r : books) {
                System.out.println(r.getAuteur()+"   "+r.getTitre()+"   "+r.getAnnee());
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        // update operation
        try (Connection connection = DriverManager
                .getConnection(jdbcURL, jdbcUsername, jdbcPassword);
             PreparedStatement statement = connection.prepareStatement(update);) {
            statement.setInt(1, 2020);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
        //delete operation
        try (Connection connection = DriverManager
                .getConnection(jdbcURL, jdbcUsername, jdbcPassword);
             PreparedStatement statement = connection.prepareStatement(delete);) {
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
        try(Connection connection = DriverManager.getConnection(jdbcURL , jdbcUsername , jdbcPassword);
        PreparedStatement statement = connection.prepareStatement("INSERT INTO public.exo1(\n" +
                "\tauteur, titre, annee)\n" +
                "\tVALUES (?, ?, ?);")){
            statement.setString(1, "Johann Wolfgang");
            statement.setString(2, "Faust");
            statement.setInt(3, 1808);

            statement.executeQuery();
        }
        catch (SQLException e) {
            System.out.println(e);
        }


    }
}