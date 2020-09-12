package ar.com.utn.ruleta.modelo.testSuit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import ar.com.utn.ruleta.controller.validatorComposite.test.JugadorAgregarValidatorTest;
import ar.com.utn.ruleta.controller.validatorComposite.test.JugadorEliminarValidatorTest;
import ar.com.utn.ruleta.controller.validatorComposite.test.JugadorModificarValidatorTest;
import ar.com.utn.ruleta.dao.test.JugadorDAOTest;
import ar.com.utn.ruleta.dao.test.Opcion1NumeroDAOTest;
import ar.com.utn.ruleta.dao.test.Opcion2NumerosDAOTest;
import ar.com.utn.ruleta.dao.test.Opcion4NumerosDAOTest;
import ar.com.utn.ruleta.dao.test.OpcionGrupoDAOTest;
import ar.com.utn.ruleta.modelo.dao.sql.selectJugadorComposite.test.SelectJugadorCompositeTest;
import ar.com.utn.ruleta.modelo.dao.sql.selectJugadorIdUnoVariosStrategy.test.SelectJugadorStrategyTest;
import ar.com.utn.ruleta.modelo.dao.util.test.ConnectionManagerTest;
import ar.com.utn.ruleta.modelo.test.NumeroTest;
import ar.com.utn.ruleta.modelo.test.NumeroTestMio;
import ar.com.utn.ruleta.modelo.test.Opcion1NumeroTest;
import ar.com.utn.ruleta.modelo.test.Opcion2NumerosTest;
import ar.com.utn.ruleta.modelo.test.Opcion4NumerosTest;
import ar.com.utn.ruleta.modelo.test.OpcionGrupoTest;

@RunWith(Suite.class)
//------------------ modelo-----------------
@SuiteClasses( {NumeroTest.class,
				//NumeroTestMio.class,      //no es un testeo de junit
				Opcion1NumeroTest.class,
				Opcion2NumerosTest.class,
				Opcion4NumerosTest.class,
				OpcionGrupoTest.class,
//---------------dao------------------------
				Opcion1NumeroDAOTest.class,		//agreg by gcasas
				Opcion2NumerosDAOTest.class,
				Opcion4NumerosDAOTest.class,
				OpcionGrupoDAOTest.class,
//---------------Composite -----------------
				SelectJugadorCompositeTest.class,
				JugadorAgregarValidatorTest.class, //agreg by gcasas
				JugadorModificarValidatorTest.class,
				JugadorEliminarValidatorTest.class,				
//---------------Strategy--------------------
				SelectJugadorStrategyTest.class,
//---------------util--------------------------
				ConnectionManagerTest.class
				
				}  
		)
public class AllTests {

}


