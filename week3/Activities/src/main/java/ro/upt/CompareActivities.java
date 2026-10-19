package ro.upt;


public class CompareActivities {
    private int cal;

    public CompareActivities(int cal) {
        this.cal = cal;
    }

    /**
     * The method checks the type of the activity and based on this type it calculates the difference between the attribute
     * of the class (cal) and the value returned by calculateCalories called on the corresponding activity.
     * @param  type  specifies the type of the activity (the possible types are provided in the ActivityType enum)
     * @param  v     variable parameter (may contain 0 to n elements and functions as an array) representing the values
     *               of the attributes for the respective activity
     * @return       the difference between the attribute of the class and the value returned by calculateCalories called on
     *               the corresponding activity
     */
    public int compare(ActivityType type, int... v) {
        if (type == null){
            throw new IncorrectValueException("type and variable parameters cannot null");
        }
        if(type == ActivityType.RUN){
            if(v.length != 1 ){
                throw new IncorrectNumberOfParameters("Run activity need 1 parameters");
            }
            return cal - new Run(v[0]).calculateCalories();
        }
        else if(type == ActivityType.BIKE){
            if(v.length != 2 ){
                throw new IncorrectNumberOfParameters("Bike activity need 2 parameters");
            }
            return cal - new Bike(v[0], v[1]).calculateCalories();
        }
        else if(type == ActivityType.SWIM){
            if(v.length != 2 ){
                throw new IncorrectNumberOfParameters("Swim activity need 2 parameters");
            }
            return cal - new Swim(v[0], v[1]).calculateCalories();
        }
        else if(type == ActivityType.UNKNOWNACTIVITY){
            return cal;
        }
        return 0;
    }
}
