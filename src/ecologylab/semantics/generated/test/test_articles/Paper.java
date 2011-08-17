package ecologylab.semantics.generated.test.test_articles;

import ecologylab.semantics.metadata.scalar.MetadataString;
import javax.persistence.ElementCollection;
import javax.persistence.CollectionTable;
import ecologylab.serialization.Hint;
import javax.persistence.Column;
import ecologylab.semantics.metametadata.MetaMetadataCompositeField;
import javax.persistence.Cacheable;
import ecologylab.serialization.simpl_inherit;
import javax.persistence.InheritanceType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import ecologylab.semantics.generated.test.test_articles.Tag;
import java.util.ArrayList;
import javax.persistence.Table;
import java.util.List;
import ecologylab.semantics.generated.test.test_articles.Article;
import org.hibernate.annotations.Type;
import javax.persistence.JoinTable;
import ecologylab.semantics.generated.test.test_articles.Paper;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Inheritance;
import javax.persistence.ManyToMany;

/**
*  Paper.java
*  s.im.pl serialization
*
*  Generated by JavaTranslator on 08/16/11.
*  Copyright 2011 Interface Ecology Lab. 
*/

/** 
 */ 
@simpl_inherit
@Entity
@Table(name = "paper")
@Cacheable
@PrimaryKeyJoinColumn(name = "orm_id")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorValue("ecologylab.semantics.generated.test.test_articles.Paper")
public class Paper extends Article
{
	/** 
	 */ 
	@simpl_scalar	@xml_tag("abstract")	@simpl_hints(Hint.XML_LEAF)	
	@Column(name = "abstract_field")
	@Type(type = "ecologylab.semantics.compiler.orm.scalartypes.MetadataStringHibernateType")
	private ecologylab.semantics.metadata.scalar.MetadataString abstractField;

	/** 
	 * Papers cited by this paper.
	 */ 
	@simpl_collection("reference")	@mm_name("references")
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "paper__references", joinColumns = @JoinColumn(name = "paper_id"), inverseJoinColumns = @JoinColumn(name = "paper_id"))
	private List<Paper> references;

	/** 
	 * Papers that cite this paper.
	 */ 
	@simpl_collection("citation")	@mm_name("citations")
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "paper__citations", joinColumns = @JoinColumn(name = "paper_id"), inverseJoinColumns = @JoinColumn(name = "paper_id"))
	private List<Paper> citations;

	/** 
	 */ 
	@simpl_collection("keyword")	@mm_name("keywords")
	@ElementCollection(fetch = FetchType.LAZY)
	@CollectionTable(name = "paper__keywords", joinColumns = @JoinColumn(name = "paper_id"))
	@Column(name = "keywords")
	@Type(type = "ecologylab.semantics.compiler.orm.scalartypes.MetadataStringHibernateType")
	private List<ecologylab.semantics.metadata.scalar.MetadataString> keywords;

	/** 
	 */ 
	@simpl_collection("tag")	@mm_name("tags")
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "paper__tags", joinColumns = @JoinColumn(name = "paper_id"), inverseJoinColumns = @JoinColumn(name = "tag_id"))
	private List<Tag> tags;

	public Paper()
	{ }

	public Paper(MetaMetadataCompositeField mmd) {
		super(mmd);
	}


	public MetadataString	abstractField()
	{
		MetadataString	result = this.abstractField;
		if (result == null)
		{
			result = new MetadataString();
			this.abstractField = result;
		}
		return result;
	}

	public String getAbstractField()
	{
		return this.abstractField == null ? null : abstractField().getValue();
	}

	public ecologylab.semantics.metadata.scalar.MetadataString getAbstractFieldMetadata()
	{
		return abstractField;
	}

	public void setAbstractField(String abstractField)
	{
		if (abstractField != null)
			this.abstractField().setValue(abstractField);
	}

	public void setAbstractFieldMetadata(ecologylab.semantics.metadata.scalar.MetadataString abstractField)
	{
		this.abstractField = abstractField;
	}

	public List<Paper> getReferences()
	{
		return references;
	}

	public void setReferences(List<Paper> references)
	{
		this.references = references;
	}

	public List<Paper> getCitations()
	{
		return citations;
	}

	public void setCitations(List<Paper> citations)
	{
		this.citations = citations;
	}

	public List<ecologylab.semantics.metadata.scalar.MetadataString> getKeywords()
	{
		return keywords;
	}

	public void setKeywords(List<ecologylab.semantics.metadata.scalar.MetadataString> keywords)
	{
		this.keywords = keywords;
	}

	public List<Tag> getTags()
	{
		return tags;
	}

	public void setTags(List<Tag> tags)
	{
		this.tags = tags;
	}
}
