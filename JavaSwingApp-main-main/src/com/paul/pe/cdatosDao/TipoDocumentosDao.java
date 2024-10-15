package com.paul.pe.cdatosDao;

import com.paul.pe.cmodelo.TipoDocumento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import  java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;



public class TipoDocumentosDao {
    private String mensaje;
    //primer metodo-insertar tipo documentos a la db
        public String agregarTipoDocumento(Connection conn, TipoDocumento tipoDocumento){
        PreparedStatement ps = null;
        String sql = "INSERT INTO TIPO_DOCUMENTO(NOMBRE,SIGLA,ESTADO,ORDEN,FECHA_ACTUALIZA) "
        + "VALUES(?,?,?,?,?)";
        
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, tipoDocumento.getNombre());
            ps.setString(2, tipoDocumento.getSigla());
            ps.setString(3, tipoDocumento.getEstado());
            ps.setInt(4, tipoDocumento.getOrden());
           // ps.setString(5, tipoDocumento.getFechaActualiza();
            
            ps.execute();
            ps.close();
            mensaje = "El tipo documento fue creado correctamente";
        } catch (Exception e) {
            mensaje = "Alto error al crear tipo documento. " + e.getMessage();
            System.out.println(e.getMessage());
        }
        return mensaje;
    }

//segundo metodo eliminar 
    
        public String eliminarTipoDocumento(Connection conn, TipoDocumento tipoDocumento){
        PreparedStatement ps = null;
        String sql = "DELETE FROM TIPO_DOCUMENTO WHERE ID_TIPO_DOCUMENTO =?";
        
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, tipoDocumento.getIdTipoDocumento());
            
          
            
            ps.execute();
            ps.close();
            mensaje ="EL TELIPO DE DOCUMENTO FUE eliminado CORRECTAMENTE";
            System.out.println("");
        } catch (SQLException e) {
            mensaje= "!ALTO¡ERROR AL eliminar TIPO DOCUMENTO. "+ e.getMessage();
            System.out.println(e.getMessage());
        }finally{
            
        }
        return mensaje;
    }
        //TERCER METODO MODIFICAR 
            public String modificarTipoDocumento(Connection conn, TipoDocumento tipoDocumento){
        PreparedStatement ps = null;
        String sql = "UPDATE TIPO_DOCUMENTO "
                + " SET NOMBRE=?,SIGLA=?,ESTADO=?,ORDEN=?"
                + " WHERE ID_TIPO_DOCUMENTO =?";
      try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, tipoDocumento.getNombre());
            ps.setString(2, tipoDocumento.getSigla());
            ps.setString(3, tipoDocumento.getEstado());
            ps.setInt(4, tipoDocumento.getOrden());
            
            //ps.setString(5, tipoDocumento.getFechaActualiza());
            ps.setInt(5, tipoDocumento.getIdTipoDocumento());

            
        ps.executeUpdate();
   
       
            
            
            
            ps.execute();
            ps.close();
            mensaje = "El tipo documento fue modificado correctamente";
        } catch (Exception e) {
            mensaje = "Alto error al modificar el tipo documento. " + e.getMessage();
            System.out.println(e.getMessage());
        }
        return mensaje;
    }
            

}
//cuarto metodo
   public void ListarTipoDocumento(Connection conn, (JTable table){
       DefaultTableModel model;
       Statement statement =null;
       ResultSet resultSet =null;

     String[] columnas =("ID","NOMBRE","SIGLA","ESTADO","ORDEN","FECHA" );
    model =new DefaultTableModel (null,columnas);

      String sql ="SELEC * FROM TIPO_DOCUMENTO";
      String[] datosTP =new String[6];

       try {
           statement = conn.createStatement();
           resultSet = statement.executeQuery(sql);
        while(resultSet.next()){
       TipoDocumento td = new TipoDocumento();
     td.setIdTipoDocumento(resultSet.getInt("ID_TIPO_DOCUMENTO"));
     td.setNombre(resultSet.getString("NOMBRE"));
     td.setIdTipoDocumento(resultSet.getInt("ESTADO"));
     td.setIdTipoDocumento(resultSet.getInt("ORDEN"));
     td.setIdTipoDocumento(resultSet.getInt("SIGLA"));
     td.setIdTipoDocumento(resultSet.getInt("FECHA_ACTUALIZACION"));
   
    datosTP[0] = td.getIdTipoDocumento()+"";
    datosTP[1] = td.getNombre()+"";
    datosTP[2] = td.getEstado()+"";
    datosTP[3] = td.getSigla()+"";
    datosTP[4] = td.getOrden()+"";
    datosTP[5] = td.getFechaActualiza()+"";

model.addRow(datosTP);
}
table.setModel(model);
       } catch (Exception e) {
    JOptionPane.showMessageDialog(null, "erro",+ e.getMessage());
           System.out.println(e.getMessage());
       }finally{
    }}
