package testVagrant;

	import java.util.ArrayDeque;
	import java.util.Deque;
	import java.util.HashMap;
	import java.util.Map;

	public class RecentlyPlayedSongs {
	    
	    private final int capacity; // initial capacity
	    private Map<String, Deque<String>> songMap; // map to store song-user pairs
	   
	    
	    
	    public static void main(String[] args) {
	        RecentlyPlayedSongs rps = new RecentlyPlayedSongs(3);
	        
	        rps.addSong("John", "S1");
	        rps.addSong("John", "S2");
	        rps.addSong("John", "S3");
	        rps.getRecentSongs("John"); // output: Recently played songs for user John: [S1, S2, S3]
	        
	        rps.addSong("John", "S4");
	        rps.getRecentSongs("John"); // output: Recently played songs for user John: [S2, S3, S4]
	        
	        rps.addSong("John", "S2");
	        rps.getRecentSongs("John"); // output: Recently played songs for user John: [S3, S4, S2]
	        
	        rps.addSong("John", "S1");
	        rps.getRecentSongs("John"); // output: Recently played songs for user John: [S4, S2, S1]
	    }
	    
	    
	    
	    
	    
	    
	    public RecentlyPlayedSongs(int capacity) {
	        this.capacity = capacity;
	        songMap = new HashMap<>();
	    }
	    
	    
	    
	    
	    
	    // method to add a song for a user
	    public void addSong(String user, String song) {
	        // if user is not already in the map, add them with a new deque
	        if (!songMap.containsKey(user)) {
	            songMap.put(user, new ArrayDeque<>());
	        }
	        Deque<String> deque = songMap.get(user);
	        deque.addLast(song); // add the song to the end of deque
	        
	        // if deque size exceeds capacity, remove the least recently played song
	        if (deque.size() > capacity) {
	            deque.removeFirst();
	        }
	    }
	    
	    
	    
	    
	    
	    // method to get recently played songs for a user
	    public void getRecentSongs(String user) {
	        if (!songMap.containsKey(user)) {
	            System.out.println("No songs found for user " + user);
	            return;
	        }
	        Deque<String> deque = songMap.get(user);
	        System.out.println("Recently played songs for user " + user + ": " + deque);
	    }
	    
	 
	}


