package terletskayasamuseva;

import terletskayasamuseva.model.DepositDTO;

import java.util.List;

public interface DepositService {
    List<DepositDTO> getAll();
    List<DepositDTO> getDepositsByParameter(DepositDTO deposit);
}
