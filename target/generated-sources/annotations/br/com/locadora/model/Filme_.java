package br.com.locadora.model;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Filme.class)
public abstract class Filme_ {

	public static volatile SingularAttribute<Filme, BigDecimal> precoUnitario;
	public static volatile SingularAttribute<Filme, Genero> genero;
	public static volatile SingularAttribute<Filme, String> nome;
	public static volatile SingularAttribute<Filme, Long> id;

}

