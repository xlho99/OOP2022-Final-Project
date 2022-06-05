
/**
 * 
 * @author xlho99
 * @version ver.0
 * @changes
 * added: 6/5
 * changed: 
 * 
 */
    
    public class SearchStore {
    	private String name;
        private String type;
        

        public boolean matchCriteria(String name, String type)
        {
            return matchesName(name) && matchesType(type);
        }

        private boolean matchesName(String name){
            return name.equals("") || name.equals(this.name) || this.name.indexOf(name) >= 0;
        }

        private boolean matchesType(String type) {
            return type.equals("") || this.type.getType().equals(type);
        }

        
    }
    


