package terletskayasamuseva;

import terletskayasamuseva.model.Credit;

public interface CreditDAO extends GenericDAO<Credit, Long>{
    Credit getCreditByName(String name);
}
