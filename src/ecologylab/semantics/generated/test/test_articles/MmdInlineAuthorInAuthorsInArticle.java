package ecologylab.semantics.generated.test.test_articles;

import ecologylab.serialization.ElementState.xml_other_tags;
import ecologylab.semantics.metadata.scalar.MetadataString;
import ecologylab.semantics.metametadata.MetaMetadataCompositeField;
import ecologylab.serialization.Hint;
import ecologylab.serialization.simpl_inherit;
import java.util.List;
import ecologylab.serialization.ElementState.xml_tag;
import ecologylab.semantics.metadata.Metadata;

/**
*  MmdInlineAuthorInAuthorsInArticle.java
*  s.im.pl serialization
*
*  Generated by JavaTranslator on 07/19/11.
*  Copyright 2011 Interface Ecology Lab. 
*/

/** 
 */ 
@simpl_inherit
public class MmdInlineAuthorInAuthorsInArticle extends Metadata
{
	/** 
	 */ 
	@simpl_scalar @simpl_composite_as_scalar	private MetadataString name;

	/** 
	 */ 
	@simpl_scalar	private MetadataString affiliation;

	public MmdInlineAuthorInAuthorsInArticle()
	{ }

	public MmdInlineAuthorInAuthorsInArticle(MetaMetadataCompositeField mmd) {
		super(mmd);
	}

	public MetadataString	name()
	{
		MetadataString	result = this.name;
		if (result == null)
		{
			result = new MetadataString();
			this.name = result;
		}
		return result;
	}

	public String getName()
	{
		return this.name().getValue();
	}


	public MetadataString getNameMetadata()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name().setValue(name);
	}


	public void setNameMetadata(MetadataString name)
	{
		this.name = name;
	}
	public MetadataString	affiliation()
	{
		MetadataString	result = this.affiliation;
		if (result == null)
		{
			result = new MetadataString();
			this.affiliation = result;
		}
		return result;
	}

	public String getAffiliation()
	{
		return this.affiliation().getValue();
	}


	public MetadataString getAffiliationMetadata()
	{
		return affiliation;
	}
	public void setAffiliation(String affiliation)
	{
		this.affiliation().setValue(affiliation);
	}


	public void setAffiliationMetadata(MetadataString affiliation)
	{
		this.affiliation = affiliation;
	}
}
