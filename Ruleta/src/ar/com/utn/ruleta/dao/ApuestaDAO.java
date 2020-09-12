package ar.com.utn.ruleta.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ar.com.utn.ruleta.modelo.Apuesta;
import ar.com.utn.ruleta.modelo.Jugador;
import ar.com.utn.ruleta.modelo.Numero;
import ar.com.utn.ruleta.modelo.Opcion1Numero;
import ar.com.utn.ruleta.modelo.dao.util.ConnectionManager;
import ar.com.utn.ruleta.modelo.exceptions.RuletaException;

public class ApuestaDAO implements DAO {

	@Override
	public void agregar(Object obj) throws ClassNotFoundException, SQLException {
		
		ConnectionManager.conectar();
		Connection conexion = ConnectionManager.getConexion();
		Statement agregar = conexion.createStatement();
		
		
		Apuesta pApuesta = (Apuesta)obj;
		
		StringBuffer sbValores = new StringBuffer("INSERT INTO ruleta.apuestas(JUG_ID, APU_NUMEROGANADOR) VALUES(");
		sbValores.append(pApuesta.getJugador().getCodigo());
		sbValores.append(",)");
		sbValores.append(pApuesta.getNumeroGanador().getValor());
		agregar.executeUpdate(sbValores.toString());
		
		ConnectionManager.desconectar();
	}

	@Override
	public void eliminar(Object obj) throws ClassNotFoundException, SQLException {
		
		ConnectionManager.conectar(); 
		Connection conexion = ConnectionManager.getConexion();
		Statement eliminar = conexion.createStatement();
		
		Apuesta pApuesta = (Apuesta)obj;
		
		StringBuffer sbValores = new StringBuffer("DELETE FROM ruleta.apuesta WHERE APU_ID= ");
		sbValores.append(pApuesta.getCodigo());
				
		eliminar.executeUpdate(sbValores.toString());
		
		ConnectionManager.desconectar();
	}


	@Override
	public void modificar(Object obj) throws ClassNotFoundException, SQLException {
		
		ConnectionManager.conectar();
		Connection conexion = ConnectionManager.getConexion();
		Statement modificar = conexion.createStatement();
		
		Apuesta pApuesta = (Apuesta)obj;
		
		StringBuffer sbValores = new StringBuffer("UPDATE FROM ruleta.apuesta set ");
		sbValores.append("JUG_ID= ");
		sbValores.append(pApuesta.getJugador().getCodigo());
		sbValores.append(", apu_numeroganador=");
		sbValores.append(pApuesta.getNumeroGanador().getValor());
		sbValores.append(" WHERE APU_ID=");
		sbValores.append(pApuesta.getCodigo());
		
		modificar.executeUpdate(sbValores.toString());
		ConnectionManager.desconectar();
	}

	
	@Override
	public List leer(Object obj) throws ClassNotFoundException, SQLException{
			
			ConnectionManager.conectar();
			Connection conexion = ConnectionManager.getConexion();
			Statement leer = conexion.createStatement();
			ResultSet rsApuestas = null;
			
			Apuesta pApuesta = (Apuesta)obj;
			
			//son todas las apuestas
			StringBuffer sb = new StringBuffer(	"SELECT apu.APU_ID, apu.jug_id, apu.apu_numeroganador, jug.jug_nombre,jug.jug_apellido, jug.jug_alias");
			sb.append(							" FROM ruleta.apuestas AS apu, ruleta.jugadores as jug");
			sb.append(							" WHERE apu.jug_id = jug.jug_id");
			//luego de aca tengo que agregas los if 
			if(pApuesta==null || pApuesta.isVacio())
				rsApuestas = leer.executeQuery(sb.toString());
			else if(pApuesta.getCodigo()>0){
				sb.append(							" AND apu.apu_id =");
				sb.append(							pApuesta.getCodigo());
				rsApuestas = leer.executeQuery(sb.toString());
			} else if (pApuesta.getNumeroGanador()!=null){
				sb.append(							" AND apu.apu_numeroganador =");
				sb.append(							pApuesta.getNumeroGanador().getValor());
				rsApuestas = leer.executeQuery(sb.toString());
			} else if (pApuesta.getJugador()!=null){
				sb.append(							" AND apu.jug_id =");
				sb.append(							pApuesta.getJugador().getCodigo());
				rsApuestas = leer.executeQuery(sb.toString());

			}
				
			List apuestas=null;
			try {
				apuestas = convertRsToObje(rsApuestas);
			} catch (RuletaException e) {
				
				e.printStackTrace();
			}
			ConnectionManager.desconectar();
			return apuestas;
		}

		private List convertRsToObje(ResultSet rs) throws SQLException, RuletaException {
			
			List<Apuesta> lstApuesta = new ArrayList<Apuesta>();
			Apuesta apuesta;
			
			while (rs.next()){
				
				apuesta = new Apuesta(rs.getInt("APU_ID"), null, new Numero(rs.getInt("apu.apu_numeroganador")), 
						new Jugador(rs.getInt("apu.jug_id"), rs.getString("jug.jug_nombre"), rs.getString("jug.jug_apellido"), rs.getString("jug.jug_alias")));				
				lstApuesta.add(apuesta);			
		}
			return lstApuesta;

		}

}
