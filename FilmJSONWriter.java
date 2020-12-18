package systémeItegration;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonWriter;

public class FilmJSONWriter {
	public static void main(String[] args) throws FileNotFoundException {

		Film f = createFilm();

		JsonObjectBuilder filmBuilder = Json.createObjectBuilder();
		JsonObjectBuilder nameBuilder = Json.createObjectBuilder();
		JsonObjectBuilder actorsBuilder = Json.createObjectBuilder();


		for (Name actor : f.getActors()) {
			((JsonArrayBuilder) actorsBuilder.add( actor.getFirst_name()))
					.add(actor.getLast_name());
			
		//	actorsBuilder.add(actor);
		}
		
		nameBuilder.add("First Name")
							.add("Last Name");
		
		filmBuilder.add("title")
					 .add("summary")
						.add("year", f.getYear());
		
		filmBuilder.add("director");
		filmBuilder.add("actors");		
		JsonObject FilmJsonObject = filmBuilder.build();
		
		System.out.println("Film JSON String\n"+FilmJsonObject);
		
		//write to file
		OutputStream os = new FileOutputStream("C:\\Users\\Toumi\\Desktop\\systémed'integration\\filmesen");
		JsonWriter jsonWriter = Json.createWriter(os);
		/**
		 * We can get JsonWriter from JsonWriterFactory also
		JsonWriterFactory factory = Json.createWriterFactory(null);
		jsonWriter = factory.createWriter(os);
		*/
		jsonWriter.writeObject(FilmJsonObject);
		jsonWriter.close();
	}
	

	public static Film createFilm() {

		Film f = new Film();
		f.setTitle("The Notebook");
		f.setSummary("A poor yet passionate young man falls in love with a rich young woman, giving her a sense of freedom,"
				+ " but they are soon separated because of their social differences.");
		f.setYear(2004);
		//write director
		Name n = new Name();
		n.setFirst_name("James ");
		n.setLast_name("Garner ");
		f.setDirector(n);
		
		//write Actors
		Name[] actors= new Name[3];
		actors[0]=new Name("Jesse","Fisenberg");
		actors[1]=new Name("Roney","Mara");
		actors[2]=new Name("Tim","Ivey");


				f.setActors(actors);
		return f;
	}

}
