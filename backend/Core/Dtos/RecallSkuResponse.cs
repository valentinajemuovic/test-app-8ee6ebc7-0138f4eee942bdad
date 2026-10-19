namespace Valentinajemuovic.SkyTravel.Backend.Core.Dtos;

public class RecallSkuResponse
{
    public string Sku { get; set; } = null!;
    public int CancelledCount { get; set; }
}
