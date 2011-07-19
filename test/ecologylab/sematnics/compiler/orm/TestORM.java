package ecologylab.sematnics.compiler.orm;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import ecologylab.semantics.generated.test.test_articles.MmdInlineAuthorInAuthorsInArticle;
import ecologylab.semantics.generated.test.test_articles.MmdInlineSourceInArticle;
import ecologylab.semantics.generated.test.test_articles.Paper;
import ecologylab.semantics.metadata.scalar.MetadataString;

public class TestORM
{
	static SessionFactory	factory;

	static
	{
		Configuration config = new Configuration();
		factory = config.configure("hibernate.cfg.xml").buildSessionFactory();
	}

	static Session newSession()
	{
		return factory.openSession();
	}

	public static void main(String[] args)
	{
		initData();
		queryAuthor("Bill Gates");
		queryAuthor("Steve Jobs");
	}

	private static void initData()
	{
		Session session = newSession();

		Transaction tx = session.beginTransaction();

		MmdInlineAuthorInAuthorsInArticle author1 = new MmdInlineAuthorInAuthorsInArticle();
		author1.setName("Bill Gates");
		author1.setAffiliation("Microsoft");
		session.save(author1);

		MmdInlineAuthorInAuthorsInArticle author2 = new MmdInlineAuthorInAuthorsInArticle();
		author2.setName("Steve Jobs");
		author2.setAffiliation("Apple");
		session.save(author2);

		MmdInlineSourceInArticle conf = new MmdInlineSourceInArticle();
		conf.setArchiveName("International Conference");
		conf.setYearOfPublication(2011);
		conf.setIsbn("123456789");
		session.save(conf);

		Paper paper1 = new Paper();
		paper1.setTitle("apple's design");
		paper1.setAuthors(new ArrayList<MmdInlineAuthorInAuthorsInArticle>());
		paper1.getAuthors().add(author1);
		paper1.setSource(conf);
		paper1.setKeywords(new ArrayList<MetadataString>());
		paper1.getKeywords().add(new MetadataString("ipad"));
		paper1.getKeywords().add(new MetadataString("ipad2"));
		paper1.getKeywords().add(new MetadataString("design"));

		Paper paper2 = new Paper();
		paper2.setTitle("bill + steve talk");
		paper2.setAuthors(new ArrayList<MmdInlineAuthorInAuthorsInArticle>());
		paper2.getAuthors().add(author1);
		paper2.getAuthors().add(author2);
		paper2.setSource(conf);
		paper2.setKeywords(new ArrayList<MetadataString>());
		paper2.getKeywords().add(new MetadataString("microsoft"));
		paper2.getKeywords().add(new MetadataString("apple"));
		paper2.setReferences(new ArrayList<Paper>());
		paper2.getReferences().add(paper1);
		
		paper1.setCitations(new ArrayList<Paper>());
		paper1.getCitations().add(paper2);
		
		session.save(paper1);
		session.save(paper2);

		tx.commit();

		session.close();
	}

	private static void queryAuthor(String name)
	{
		System.out.println("queyring author " + name + ":");
		
		Session session = newSession();

		List<Paper> targetPapers = session.createCriteria(Paper.class)
				.createCriteria("authors")
				.add(Restrictions.eq("name", name))
				.list();

		for (Paper p : targetPapers)
		{
			System.out.format("%s'%d: (%d) %s, %s, %d reference(s), %d citation(s).",
					p.getSource().getArchiveName(),
					p.getSource().getYearOfPublication(),
					p.getOrmId(),
					getAuthorList(p.getAuthors()),
					p.getTitle(),
					p.getReferences().size(),
					p.getCitations().size());
			System.out.println();
		}

		session.close();
	}

	private static String getAuthorList(List<MmdInlineAuthorInAuthorsInArticle> authors)
	{
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < authors.size(); ++i)
		{
			MmdInlineAuthorInAuthorsInArticle a = authors.get(i);
			String name = a.getName();
			if (i > 0)
				sb.append(" and ");
			sb.append(name);
		}
		return sb.toString();
	}

}
