import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Set;

public class Detal {
    @Size(min = 4, message = "ID")
    @Pattern(regexp = "[1-9]+", message = "id must be a numder ")
    private int id;

    @Size(min = 4, message = "Articul")
    @Pattern(regexp = "[1-100]+", message = "Articul must be a number")
    private int Articul;

    @Size(min = 3, message = "Name must be more than 2 character")
    @Pattern(regexp = "[A-Z][a-z]+", message = "Name must consists only from letter")
    private String Name;

    @Size(min = 4, message = "ID Proizvoditelya")
    @Pattern(regexp = "[1-9]+", message = "id must be a numder ")
    private int idProizvoditel;

    @Min(value = 500, message = "Price must be more than 500")
    @Max(value = 100000, message = "Price cannot be more than 100000")
    private float Price;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getIdProizvoditel() {
        return idProizvoditel;
    }

    public void setIdProizvoditel(int idProizvoditel) {
        this.idProizvoditel = idProizvoditel;
    }

    public float getPrice() {
        return Price;
    }

    public void setPrice(float price) {
        Price = price;
    }

    public int getArticul() {
        return Articul;
    }

    public void setArticul(int articul) {
        Articul = articul;
    }

    public static class Builder{

        private Detal detal;

        public Builder(){
            detal = new Detal();
        }

        public Builder setId(int id){
            detal.id = id;
            return this;
        }


        public Builder setName(String name){

            detal.Name = name;
            return this;
        }

        public Builder setidProizvoditel(int idproizvoditel){
            detal.idProizvoditel = idproizvoditel;
            return this;
        }

        public Builder setArticul(int articul){
            detal.Articul = articul;
            return this;
        }

        public Builder setPrice(float price){
            detal.Price = price;
            return this;
        }


        public Detal build(){
            validate(detal);
            return detal;
        }
    }
    private static void validate(Detal detal) throws IllegalArgumentException {

        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();


        Set<ConstraintViolation<Detal>> check = validator.validate(detal);

        StringBuilder sb = new StringBuilder();

        for(ConstraintViolation<Detal> i : check){
            sb.append("Error value "+i.getInvalidValue() + " because " + i.getMessage());
            sb.append("\n");
        }

        if(sb.length() > 0){
            throw new IllegalArgumentException(sb.toString());
        }
    }
    public static void main(String args[]){
        try {
            Detal detal = new Detal.Builder()
                    .setId(1)
                    .setName("Porshen")
                    .setidProizvoditel(5)
                    .setPrice(8525)
                    .setArticul(7)
                    .build();
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }




}






