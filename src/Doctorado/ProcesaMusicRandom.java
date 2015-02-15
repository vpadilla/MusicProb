package Doctorado;
import jm.JMC;
import jm.music.data.*;
import jm.util.View;
import jm.util.Write;
public class ProcesaMusicRandom {

	private String strMusicInit;
	private String strMusicFinal;
	private int partes;
	private int repeticiones;
	private int  semicorcheasSilencio;
	private double puntoComienzoInit;
	private double puntoComienzoFin;
	private double probSilencio;

	private double probMutacionInit;
	private double probMutacionFin;
	private String distribucionProbabilidadInit;
	private String distribucionProbabilidadFin;
	private String distribucionProbabilidadSilencio;
	private String pathOutMidi;
	private boolean isCrecienteInit;
	private boolean isCrecienteFin;
	private boolean isQuitarInicioInit;
	private boolean isQuitarInicioFin;
	
	public void setHead(String strMusic, double startPoint, double mutationProb, String  distributionProbType, boolean increase, boolean removeStart)
	{
		this.strMusicInit=strMusic;
		this.puntoComienzoInit=startPoint;
		this.probMutacionInit=mutationProb;
		this.distribucionProbabilidadInit=distributionProbType;
		this.isCrecienteInit=increase;
		this.isQuitarInicioInit=removeStart;
	}
	public void setEnd(String strMusic, double startPoint, double mutationProb, String  distributionProbType, boolean increase, boolean removeStart)
	{
		this.strMusicFinal=strMusic;
		this.puntoComienzoFin=startPoint;
		this.probMutacionFin=mutationProb;
		this.distribucionProbabilidadFin=distributionProbType;
		this.isCrecienteFin=increase;
		this.isQuitarInicioFin=removeStart;
	}
	public void setSilence(double mutationProb, String  distributionProbType, int repeat, int parts, int semiquavers)
	{
		this.probSilencio=mutationProb;
		this.distribucionProbabilidadSilencio=distributionProbType;
		this.repeticiones=repeat;
		this.partes=parts;
		this.semicorcheasSilencio=semiquavers;
		
	}
	public void setOutMidi(String pathOutMidi)
	{
		this.pathOutMidi=pathOutMidi;
	}
	public void procesa()
	{
		Score s = new Score("Texturas");

	    for(int inst=0;inst<partes;inst++)//partes instrumentales
	    {
			Part p = new Part("Melody", 1, 0);
			for(int j=1;j<repeticiones;j++)
			{

		     Phrase phrInit = new Phrase();
		     phrInit=getPhrase(strMusicInit,puntoComienzoInit,j,repeticiones,2,distribucionProbabilidadInit,probMutacionInit,isCrecienteInit,isQuitarInicioInit);
		     Phrase phrFinal = new Phrase();
		     phrFinal=getPhrase(strMusicFinal,puntoComienzoFin,j,repeticiones,2,distribucionProbabilidadFin,probMutacionFin,isCrecienteFin,isQuitarInicioFin);
		     Phrase phrSilencio = new Phrase();
		     phrSilencio=getSilencio(semicorcheasSilencio,0,j,repeticiones,2,distribucionProbabilidadSilencio,probSilencio);
		     

			 p.addPhrase(phrInit);
			 p.addPhrase(phrFinal);
			 p.addPhrase(phrSilencio);
			 
		     
			}
			s.addPart(p);
	    }
	        View.show(s);

	        Write.midi(s, pathOutMidi);
	    }

	public int convert(String strInput)
	{
		int intOut=0;
		
		if(strInput.equals("c")) intOut=60;
		if(strInput.equals("^c")) intOut=61;
		if(strInput.equals("d")) intOut=62;
		if(strInput.equals("^d")) intOut=63;
		if(strInput.equals("e")) intOut=64;
		if(strInput.equals("f")) intOut=65;
		if(strInput.equals("^f")) intOut=66;
		if(strInput.equals("g")) intOut=67;
		if(strInput.equals("^g")) intOut=68;
		if(strInput.equals("a")) intOut=69;
		if(strInput.equals("^a")) intOut=70;
		if(strInput.equals("b")) intOut=71;
		
		if(strInput.equals("B")) intOut=59;
		if(strInput.equals("^A")) intOut=58;
		if(strInput.equals("A")) intOut=57;
		if(strInput.equals("^G")) intOut=56;
		if(strInput.equals("G")) intOut=55;
		if(strInput.equals("^F")) intOut=54;
		if(strInput.equals("F")) intOut=53;
		if(strInput.equals("E")) intOut=52;
		if(strInput.equals("^D")) intOut=51;
		if(strInput.equals("D")) intOut=50;
		if(strInput.equals("^C")) intOut=49;
		if(strInput.equals("C")) intOut=48;
		
		
		intOut+=12;
		return intOut;
		
	}
	public double getDistribution(String distProb, double probMutacion)
	{
		 
		 double alea;
		 double mayor=100;
		 double menor=100-probMutacion*100;
		 double distribucion=0;
		 if(distProb.equals("Uniforme"))
		 {
			 distribucion=StdRandom.uniform();
		 }
		 if(distProb.equals("Poisson"))
		 {
			 distribucion=StdRandom.poisson(10)/20.0;
		 }
		 if(distProb.equals("Gaussiana"))
		 {
			 distribucion=StdRandom.gaussian();
		 }
		 alea=(distribucion*(mayor-menor)+menor)/100;
		 
		 return alea;
	}
	private Phrase getPhrase(String str, double puntoComienzo,int repeticion, int repeticiones, int quitarElementos, String distribucionProbabilidad, double probMutacion, boolean isCreciente, boolean isQuitarInicio)
	{
		Phrase phr = new Phrase();
		boolean yaQuitado=false;
		int longitud=str.length();
		 for(int i=0;i<longitud;i++)
			  {
			
			double alea=getDistribution(distribucionProbabilidad, probMutacion);
			 if((1.0*repeticion/repeticiones)>(puntoComienzo)  && i<(longitud-(int)((alea*repeticion*longitud*1.0)/(repeticiones*1.0))))
				 {
				 
				 if(!yaQuitado)
					 {
						 if(isCreciente)
						 {
							 if(isQuitarInicio)
							 {
								 i+=(int)((alea*(repeticiones-repeticion)*longitud*1.0)/(repeticiones*1.0));
							 }
							 else
							 {
								 longitud-=(int)((alea*(repeticiones-repeticion)*longitud*1.0)/(repeticiones*1.0));
							 }
						 }
						 else
						 { 
							 if(isQuitarInicio)
							 {
								 i+=(int)((alea*(repeticion)*longitud*1.0)/(repeticiones*1.0));	
							 }
							 else
							 {
								 longitud-=(int)((alea*(repeticion)*longitud*1.0)/(repeticiones*1.0));
							 }
						 }
						 yaQuitado=true;
					 }
				 }
				String strNota=str.substring(i, i+1);
				//para alteraciones
				if (strNota.equals("^")|| strNota.equals("_"))
				{
					strNota=str.substring(i, i+2);
					i++;
				}
			   int intNota=convert(strNota);
		       Note note = new Note(intNota, 0.25,2);
		       phr.addNote(note);
		       
			  }
		return phr;
	}
	private Phrase getSilencio(double duracion, double puntoComienzo,int repeticion, int repeticiones, int quitarElementos,String distribucionProbabilidad, double probMutacion)
	{
		Phrase phr = new Phrase();

			 double alea=getDistribution(distribucionProbabilidad, probMutacion);
			 		int intRandom=(int)(alea*1.0*duracion);
			 		System.out.println(intRandom+"\n");
					 Note note = new Note(0, 0.25*intRandom,0);
			 		//Rest rest=new Rest(0.25*intRandom);
					phr.addNote(note);
		
				 
			 return phr;
		
	}
	

}