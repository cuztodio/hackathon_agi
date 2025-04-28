@Service
@RequiredArgsConstructor
public class MovimentacaoService {

    private final MovimentacaoRepository movimentacaoRepository;

    public Movimentacao createMovement(Movimentacao movimentacao) {
        movimentacao.setDataMovimentacao(LocalDateTime.now());
        movimentacao.setStatus(StatusMovimentacao.EMPRESTADO);
        return movimentacaoRepository.save(movimentacao);
    }

    public Movimentacao finalizeMovement(String movementId) {
        return movimentacaoRepository.findById(movementId)
                .map(m -> {
                    m.setDataDevolucao(LocalDateTime.now());
                    m.setStatus(StatusMovimentacao.DEVOLUCAO);
                    return movimentacaoRepository.save(m);
                })
                .orElseThrow(() -> new RuntimeException("Movement not found"));
    }

    public List<Movimentacao> getEmployeeHistory(String employeeId) {
        return movimentacaoRepository.findByFuncionarioId(employeeId);
    }
}
