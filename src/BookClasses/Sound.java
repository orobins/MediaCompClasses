//Ormelia Robinson
//ITIS 1213
package BookClasses;


/**
 * Class that represents a sound.  This class is used by the students
 * to extend the capabilities of SimpleSound. 
 * 
 * Copyright Georgia Institute of Technology 2004
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
public class Sound extends SimpleSound
{
  
  /////////////// consructors ////////////////////////////////////
  
  /**
   * Constructor that takes a file name
   * @param fileName the name of the file to read the sound from
   */
  public Sound(String fileName)
  {
    // let the parent class handle setting the file name
    super(fileName);
  }
  
  /**
   * Constructor that takes the number of samples in
   * the sound
   * @param numSamples the number of samples desired
   */
  public Sound (int numSamples)
  {
    // let the parent class handle this
    super(numSamples);
  }
  
  /**
   * Constructor that takes the number of samples that this
   * sound will have and the sample rate
   * @param numSamples the number of samples desired
   * @param sampleRate the number of samples per second
   */
  public Sound (int numSamples, int sampleRate)
  {
    // let the parent class handle this
    super(numSamples,sampleRate);
  }
  
  /**
   * Constructor that takes a sound to copy
   */
  public Sound (Sound copySound)
  {
    // let the parent class handle this
    super(copySound);
  }
  
  ////////////////// methods ////////////////////////////////////
  
  /**
   * Method to return the string representation of this sound
   * @return a string with information about this sound
   */
  public String toString()
  {
    String output = "Sound";
    String fileName = getFileName();
    
    // if there is a file name then add that to the output
    if (fileName != null)
      output = output + " file: " + fileName;
    
    // add the length in frames
    output = output + " number of samples: " + getLengthInFrames();
    
    return output;
  }
 
  public static void main(String[] args)
  {
    Sound sound1 = new Sound(FileChooser.pickAFile());
    sound1.explore();
  }
          //Method to double the volume(amplitude) of the sound
        public void increaseVolume()
        {
            SoundSample[] sampleArray = this.getSamples();
            SoundSample sample = null;
            int value = 0;
            int index = 0;
            //loop through all the samples in the array
            while(index<sampleArray.length){
                sample = sampleArray[index];
                value = sample.getValue();
                sample.setValue(value*2);
                index++;
            }
        }
        //Method to change the volume(amplitude) of the sound by multiplying the
        //current values in the sound by the passed factor
        public void changeVolume(double factor){
            SoundSample[] sampleArray = this.getSamples();
            SoundSample sample;
            int value;
            //loop through all the samples in the array
            for(int i = 0; i < sampleArray.length; i++){
                sample = sampleArray[i];
                value = sample.getValue();
                sample.setValue((int)(value*factor));
            }
        }
        //Method to set all the sample values to the maximum positive value if
        //they were positive and the minimum negative value if they were negative
        public void forceToExtremes(){
            SoundSample[] sampleArray = this.getSamples();
            SoundSample sample;
            //loop through all the elements in the array
            for(int i = 0; i < sampleArray.length; i++){
                //get the current sample
                sample = sampleArray[i];
                //if the value was positive set it to the max positive value
                if(sample.getValue()>=0)
                    sample.setValue(32767);
                //else force to max negative value
                else
                    sample.setValue(-32767);
            }
        }
        /**
         * Takes all the values below zero and changes it to zero
         * @return integer, number of samples clipped 
         */
        public int clipLows(){
            SoundSample[] sampleArray = this.getSamples();
            SoundSample sample = null;
            int number = 0;
            
            for(int i = 0; i < sampleArray.length; i++){
                sample = sampleArray[i];
                if(sample.getValue() < 0){
                    sample.setValue(0);
                    number++;
                }
            }
            return number;
        }
             
} // this } is the end of class Sound, put all new methods before this