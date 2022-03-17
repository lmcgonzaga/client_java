package dao;
/**
 *
 * @author Ludwig Gonzaga
 */
/*import necessário*/
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Cliente;
import model.Endereco;
import model.Funcionario;
import model.Pessoa;
import model.PessoaEndereco;
/**
 *
 * @author Ludwig Gonzaga
 */
public class PessoaDAO {
    public static Connection getConnection(){
        Connection con = null;
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con =(Connection) DriverManager.getConnection("jdbc:mysql//localhost:3306/minhaloja","ludwig_gonzaga","SierraGolf@2020");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
        return con;
    }
    
    public static List<Cliente> getAllCLientes(){
        List<Cliente> list = new ArrayList<Cliente>();
        
        try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT clie.emailcliente, p.idpessoa,clie.idcliente,e.idendereco,pe.idpessoaendereco ,p.nomepessoa ,p.sobrenomepessoa,p.datanascimento ,e.cidade ,e.unidadefederacao \n" +
                                                        "FROM cliente clie \n" +
                                                        "LEFT JOIN pessoa p \n" +
                                                        "ON p.idpessoa = clie.idpessoa \n" +
                                                        "LEFT JOIN pessoa_endereco pe \n" +
                                                        "ON p.idpessoa = pe.idpessoa \n" +
                                                        "LEFT JOIN endereco e \n" +
                                                        "ON pe.idendereco = e.idendereco \n" +
                                                        "ORDER BY p.nomepessoa ASC ");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Cliente cliente = new Cliente();
                cliente.setIdcliente(rs.getInt("idcliente"));
                cliente.setIdcliente(rs.getInt("idpessoa"));
                cliente.setEmailcliente(rs.getString("emailcliente"));
                cliente.setIdcliente(rs.getInt("idcadastrante"));
                list.add(cliente);               
            }          
            
        } catch (Exception e) {
            System.out.println();
        }
        return list;
    }
    
    
}