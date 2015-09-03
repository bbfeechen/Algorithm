package interview;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ixl_learning_4 {
	public class User {
		public boolean getAnswer() {
			return true;
		};
	}
	
	public class Sound {
		
	}
	
	private Sound error_sound = new Sound();
	private Sound prev_used = new Sound();
	private List<Sound> correct_sounds = new ArrayList<Sound>();
	private User user = new User();
	
	private void play(Sound sound) {
		
	}
	
	public void playSound() {
		boolean correct = user.getAnswer();        //assume there’s user class
	    if(!correct) {
	        play(error_sound);
	        if(prev_used != null) {
	            correct_sounds.add(prev_used);
	            prev_used = null;
	        }
	    } else {
	        Random r = new Random();
	        int ran_index = r.nextInt(correct_sounds.size());
	        Sound correct_sound = correct_sounds.get(ran_index);
	        play(correct_sound);
	        correct_sounds.remove(correct_sound);
	        if(prev_used != null) {
	            correct_sounds.add(prev_used);
	        }
	        prev_used = correct_sound;
	    }
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
