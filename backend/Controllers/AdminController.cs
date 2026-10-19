using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Mvc;
using Valentinajemuovic.SkyTravel.Backend.Api.Security;
using Valentinajemuovic.SkyTravel.Backend.Core.Services;

namespace Valentinajemuovic.SkyTravel.Backend.Controllers;

[ApiController]
[Authorize(Roles = Roles.Admin)]
[Route("api/admin")]
public class AdminController : ControllerBase
{
    private readonly OrderService _orderService;

    public AdminController(OrderService orderService)
    {
        _orderService = orderService;
    }

    [HttpPost("recall/{sku}")]
    public async Task<IActionResult> RecallSku(string sku)
    {
        var response = await _orderService.RecallSkuAsync(sku);
        return Ok(response);
    }
}
