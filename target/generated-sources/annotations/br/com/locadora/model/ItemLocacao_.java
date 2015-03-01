package br.com.locadora.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ItemLocacao.class)
public abstract class ItemLocacao_ {

	public static volatile SingularAttribute<ItemLocacao, Long> id;
	public static volatile SingularAttribute<ItemLocacao, Locacao> locacao;
	public static volatile SingularAttribute<ItemLocacao, Filme> filme;

}

