package ecologylab.semantics.generated.library;

/**
*  RepositoryMetadataTranslationScope.java
*  s.im.pl serialization
*
*  Generated by JavaTranslator on 08/15/11.
*  Copyright 2011 Interface Ecology Lab. 
*/




import ecologylab.serialization.TranslationScope;

import ecologylab.semantics.namesandnums.SemanticsNames;

import ecologylab.semantics.metadata.builtins.MetadataBuiltinsTranslationScope;

/**
 * This is the tranlation scope class for generated files.
 */

public class RepositoryMetadataTranslationScope
{
	protected static final Class TRANSLATIONS[] =
	{
		ecologylab.semantics.generated.test.test_articles.Article.class,

		ecologylab.semantics.generated.test.test_articles.Paper.class,

	};

	public static TranslationScope get()
	{
		return TranslationScope.get(SemanticsNames.REPOSITORY_METADATA_TRANSLATIONS, MetadataBuiltinsTranslationScope.get(), TRANSLATIONS);
	}

}
