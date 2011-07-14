package ecologylab.semantics.generated.test.test_articles;

import ecologylab.serialization.ElementState.xml_other_tags;
import ecologylab.semantics.metadata.scalar.MetadataString;
import ecologylab.semantics.metametadata.MetaMetadataCompositeField;
import ecologylab.serialization.Hint;
import ecologylab.serialization.simpl_inherit;
import ecologylab.net.ParsedURL;
import ecologylab.serialization.ElementState.xml_tag;
import ecologylab.semantics.metadata.scalar.MetadataParsedURL;
import ecologylab.semantics.metadata.Metadata;

/**
*  MmdInlineTagInTagsInPaper.java
*  s.im.pl serialization
*
*  Generated by JavaTranslator on 07/13/11.
*  Copyright 2011 Interface Ecology Lab. 
*/

/** 
 */ 
@simpl_inherit
public class MmdInlineTagInTagsInPaper extends Metadata
{
	/** 
	 */ 
	@simpl_scalar	private MetadataParsedURL link;

	/** 
	 */ 
	@simpl_scalar	private MetadataString tagName;

	public MmdInlineTagInTagsInPaper()
	{ }

	public MmdInlineTagInTagsInPaper(MetaMetadataCompositeField mmd) {
		super(mmd);
	}

	public MetadataParsedURL	link()
	{
		MetadataParsedURL	result = this.link;
		if (result == null)
		{
			result = new MetadataParsedURL();
			this.link = result;
		}
		return result;
	}

	public ParsedURL getLink()
	{
		return this.link().getValue();
	}

	public void setLink(ParsedURL link)
	{
		this.link().setValue(link);
	}

	public MetadataString	tagName()
	{
		MetadataString	result = this.tagName;
		if (result == null)
		{
			result = new MetadataString();
			this.tagName = result;
		}
		return result;
	}

	public String getTagName()
	{
		return this.tagName().getValue();
	}

	public void setTagName(String tagName)
	{
		this.tagName().setValue(tagName);
	}

}
